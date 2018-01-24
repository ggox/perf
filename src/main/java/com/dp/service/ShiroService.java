package com.dp.service;

import java.util.List;

import com.dp.entity.UserMenu;

public interface ShiroService extends DefaultBaseService{

	List<UserMenu> selectUserMenusTreeByAccount(String account) throws Exception;

}
