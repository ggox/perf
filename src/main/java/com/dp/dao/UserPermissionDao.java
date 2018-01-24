package com.dp.dao;

import java.util.Set;

public interface UserPermissionDao extends AbstractDefaultDao{

	Set<String> selectPermissionByAccount(String account) throws Exception;
	
}