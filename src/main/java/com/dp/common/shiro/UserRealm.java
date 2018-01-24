package com.dp.common.shiro;

import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dp.common.exceptions.CaptchaException;
import com.dp.common.servlet.CaptchaServlet;
import com.dp.entity.User;
import com.dp.entity.UsernamePasswordCaptchaToken;
import com.dp.service.ShiroService;
import com.github.pagehelper.util.StringUtil;

public class UserRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	@Resource
	private ShiroService shiroService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 1. 从 PrincipalCollection 中来获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();
		Set<String> roles = null;
		Set<String> permissions = null;
		try {
			// 2.1查询用户角色
			roles = shiroService.queryUserRoleByName((String) principal);
			// 2.2查询用户权限字符串集合
			permissions = shiroService.queryPermissionByUsername((String) principal);
			
		} catch (Exception e) {
			logger.error("查询用户角色和权限失败！");
		}
		// 3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		// 4. 返回 SimpleAuthorizationInfo 对象.
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 1. 把 AuthenticationToken 转换为 UsernamePasswordToken
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authenticationToken;

		// 2. 从 UsernamePasswordToken 中来获取 username
		String username = token.getUsername();

		if (StringUtil.isEmpty(username)) {
			throw new AccountException("用户名不能为空！");
		}
		Session session = SecurityUtils.getSubject().getSession();
		// 增加判断验证码逻辑
		String captcha = token.getCaptcha();
		logger.info("提交验证码：" + token.getCaptcha());
		String exitCode = (String) session.getAttribute(CaptchaServlet.KEY_CAPTCHA);
		logger.info("sessionId:" + session.getId());
		logger.info("session验证码:" + exitCode);
		if (null == captcha || !captcha.equalsIgnoreCase(exitCode)) {
			throw new CaptchaException("VerificationCodeIsNotCorrect");
		}
		// 3. 调用数据库的方法, 从数据库中查询 username 对应的用户记录
		User user = null;
		try {
			user = shiroService.queryUserByName(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UnknownAccountException("AccountAndPasswordAuthenticationFailed");
		}

		// 4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
		if (user == null) {
			throw new UnknownAccountException("AccountAndPasswordAuthenticationFailed");
		}
		// 5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
		// TODO

		// 6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为:
		// SimpleAuthenticationInfo
		// 以下信息是从数据库中获取的.
		// 1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
		Object principal = username;
		// 2). credentials: 密码.
		Object credentials = user.getPassword();

		// 3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		// 4). 盐值.
		ByteSource credentialsSalt = null;
		if (user.getSalt() != null) {
			credentialsSalt = ByteSource.Util.bytes(user.getSalt());
		}

		SimpleAuthenticationInfo info = null; // new
		// SimpleAuthenticationInfo(principal,
		// credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}

}
