package com.dp.dao;

import java.util.List;

import com.dp.entity.UserMenu;

public interface UserMenuDao extends AbstractDefaultDao{
	List<UserMenu> selectMenus(String account) throws Exception;
}