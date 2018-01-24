package com.dp.dao;

import com.dp.entity.User;

public interface UserDao extends AbstractDefaultDao{

	User selectUserByAccount(String username) throws Exception;
	
}