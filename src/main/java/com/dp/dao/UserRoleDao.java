package com.dp.dao;

import java.util.Set;

public interface UserRoleDao extends AbstractDefaultDao{

	Set<String> selectUserRoleByAccount(String account) throws Exception;
	
}