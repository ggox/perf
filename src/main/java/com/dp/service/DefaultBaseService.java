package com.dp.service;

import java.util.List;
import java.util.Set;

import com.dp.entity.User;
import com.dp.entity.UserMenu;

public interface DefaultBaseService {
	User queryUserByName(String username) throws Exception;

	Set<String> queryUserRoleByName(String account) throws Exception;

	Set<String> queryPermissionByUsername(String account) throws Exception;

	List<UserMenu> selectUserMenusByAccount(String account) throws Exception;
}
