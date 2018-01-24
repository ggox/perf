package com.dp.dao;

public interface AbstractDefaultDao {
	int deleteByPrimaryKey(Integer id) throws Exception;

	<T> int insert(T record) throws Exception;

	<T> int insertSelective(T record) throws Exception;

	<T> T selectByPrimaryKey(Integer id) throws Exception;

	<T> int updateByPrimaryKeySelective(T record) throws Exception;

	<T> int updateByPrimaryKey(T record) throws Exception;

}
