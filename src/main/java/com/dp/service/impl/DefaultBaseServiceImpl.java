package com.dp.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.dp.dao.UserDao;
import com.dp.dao.UserMenuDao;
import com.dp.dao.UserPermissionDao;
import com.dp.dao.UserRoleDao;
import com.dp.entity.User;
import com.dp.entity.UserMenu;
import com.dp.service.DefaultBaseService;

public class DefaultBaseServiceImpl implements DefaultBaseService {
	@Autowired
	private UserMenuDao userMenuDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private UserPermissionDao userPermissionDao;
	@Autowired
	private UserDao userDao;

	@Override
	public User queryUserByName(String username) throws Exception {
		return userDao.selectUserByAccount(username);
	}

	@Override
	public Set<String> queryUserRoleByName(String account) throws Exception {
		return userRoleDao.selectUserRoleByAccount(account);
	}

	@Override
	public Set<String> queryPermissionByUsername(String account) throws Exception {
		return userPermissionDao.selectPermissionByAccount(account);
	}

	@Override
	public List<UserMenu> selectUserMenusByAccount(String account) throws Exception {
		return userMenuDao.selectMenus(account);
	}

}
