package com.dp.common.context;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.dp.entity.User;
import com.dp.entity.UserMenu;

public class UserContext {
	private String account;
	private User user;
	private List<UserMenu> userMenus;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<UserMenu> getUserMenus() {
		return userMenus;
	}
	public void setUserMenus(List<UserMenu> userMenus) {
		this.userMenus = userMenus;
	}
	public static UserContext getUserContext() {
		Session session = SecurityUtils.getSubject().getSession();
		Object obj = session.getAttribute("userContext");
		if(obj == null){
			session.setAttribute("userContext", new UserContext());
			return (UserContext) session.getAttribute("userContext");
		}
		return (UserContext)obj;
	}
}
