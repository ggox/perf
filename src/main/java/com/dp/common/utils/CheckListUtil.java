package com.dp.common.utils;

import java.util.List;

public class CheckListUtil {
	/**
	 * list是否null
	 * @param list
	 * @return
	 */
	public static boolean isListNull(List list){
		if(list == null){
			return true;
		}
		return false;
	}
	/**
	 * list 是否为null 或者空（size()==0）
	 */
	public static boolean isListEmpty(List list){
		if(list == null || list.isEmpty()){
			return true;
		}
		return false;
	}
}
