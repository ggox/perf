package com.dp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dp.dao.UserMenuDao;
import com.dp.entity.UserMenu;
import com.dp.service.ShiroService;
import com.github.pagehelper.util.StringUtil;

@Service(value = "shiroService")
@Transactional
public class ShiroServiceImpl extends DefaultBaseServiceImpl implements ShiroService {
	@Autowired
	private UserMenuDao userMenuDao;

	@Override
	public List<UserMenu> selectUserMenusTreeByAccount(String account) throws Exception {
		return searchMenu(userMenuDao.selectMenus(account),0);
	}
	//递归处理菜单
	private List<UserMenu> searchMenu(List<UserMenu> list,int parentId){
		List<UserMenu> rList = new ArrayList<UserMenu>();;
		for (UserMenu userMenu : list) {
			if(userMenu.getParentId() == parentId){
				if(StringUtil.isEmpty(userMenu.getUrl())){//不加则多处理一环，视业务情况而定
					userMenu.setSubUserMenus(searchMenu(list,userMenu.getId()));
				}
				rList.add(userMenu);
			}
		}
		return rList;
	}
	
}
