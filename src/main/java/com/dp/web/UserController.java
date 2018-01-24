package com.dp.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dp.common.context.UserContext;
import com.dp.common.exceptions.CaptchaException;
import com.dp.entity.UserMenu;
import com.dp.entity.UsernamePasswordCaptchaToken;
import com.dp.service.ShiroService;

@Controller
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource
	ShiroService shiroService;

	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login() {
		/// 解决：直接关闭浏览器时session没有失效，下次可以直接访问需要登录访问的资源
		if (SecurityUtils.getSubject().getSession(false) != null) {
			SecurityUtils.getSubject().logout();
		}
		
		logger.info("跳转登录！");
		return "login";
	}

	/**
	 * 登入校验
	 */
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public String loginCheck(@RequestParam(value="username",required=true)String username,
			@RequestParam(value="password",required=true)String password,@NotEmpty@RequestParam(value="captcha",required=true)String captcha) {
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isAuthenticated()){//未认证
			UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username, password, captcha);
			token.setRememberMe(false);
			try {
				logger.info("开始认证！");
				currentUser.login(token);
				logger.info("认证通过！");
				// 初始化数据，查询菜单（后期可以做成service方法）
				List<UserMenu> userMenus = shiroService.selectUserMenusTreeByAccount(username);
				UserContext userContext = UserContext.getUserContext();
				userContext.setAccount(username);
				userContext.setUserMenus(userMenus);
			} catch (CaptchaException e) {
				logger.error("验证码错误！");
				return "redirect:/login";
			} catch (UnknownAccountException e) {
				logger.error("账号不存在！");
				return "redirect:/login";
			} catch (IncorrectCredentialsException e) {
				logger.error("密码错误！");
				return "redirect:/login";
			} catch (Exception e) {
				logger.error("其他错误！");
				e.printStackTrace();
				return "redirect:/login";
			}
		}
		return "loginsuccess";
	}
	
	
	/**
	 * 注销
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private String logout(){
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			currentUser.logout();
		}
		return "redirect:/login";
	} 
	
	/**
	 * test
	 */
	@RequestMapping(value = "/test/{flagValue}", method = RequestMethod.GET)
	@RequiresRoles("admin")
	public String test(HttpServletRequest request, Map<String, Object> map,
			@PathVariable(value = "flagValue") String flag) {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			if(currentUser.isAuthenticated()){
				logger.info(flag);
				map.put("flag", flag);
			}else{
				map.put("flag","没有认证");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "test";
	}
	
}
