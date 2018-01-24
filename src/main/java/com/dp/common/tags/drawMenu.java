package com.dp.common.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dp.common.utils.CheckListUtil;
import com.dp.entity.UserMenu;

public class drawMenu extends SimpleTagSupport {
	private List<UserMenu> userMenus;
	
	private PageContext pageContext;
	
	private String contextPath;
	
	public void setUserMenus(List<UserMenu> userMenus) {
		this.userMenus = userMenus;
	}

	@Override
	public void doTag() throws JspException, IOException {
		pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		contextPath = request.getContextPath();
		try {
			//没有子节点
			StringBuffer sb = new StringBuffer();
			drawNormalMenu(userMenus,sb);
			out.print(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			out.print("菜单渲染出错！");
		}
	}
	private void drawNormalMenu(List<UserMenu> userMenus,StringBuffer sb){
		sb.append("<ul class=\"treeview-menu\">");
		for (UserMenu userMenu : userMenus) {
			if(CheckListUtil.isListEmpty(userMenu.getSubUserMenus())){
				sb.append("<li id=\"menu-"+userMenu.getId()+"\" parentIds=\""+userMenu.getParentIds()+"\"><a href=\"" +contextPath+userMenu.getUrl() + "\"><i class=\"" + userMenu.getIcon() + "\"></i> "
						+ userMenu.getName() + "</a></li>");
			}else{
				sb.append("<li id=\"menu-"+userMenu.getId()+"\" parentIds=\""+userMenu.getParentIds()+"\">");
				sb.append("<a href=\"#\"><i class=\""+userMenu.getIcon()+"\"></i> "+userMenu.getName()
					+"<span class=\"pull-right-container\"> <i class=\"fa fa-angle-left pull-right\"></i></span></a>");
				drawNormalMenu(userMenu.getSubUserMenus(),sb);
				sb.append("</li>");
			}
		}
		sb.append("</ul>");
	}
}
