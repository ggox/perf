package com.dp.common.shiro;

import java.util.LinkedHashMap;

import com.dp.service.ShiroService;

public class FilterChainDefinitionMapBuilder {
	
	private ShiroService shiroService;
	
	public void setShiroService(ShiroService shiroService) {
		this.shiroService = shiroService;
	}

	public LinkedHashMap<String, String> buildFilterChainDefinitionMap(){
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		try {
			//map = shiroService.selectResourceAuthc();
			map.put("/**", "user");//其他未定义资源需要登录访问或者记住我 放在最后
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
