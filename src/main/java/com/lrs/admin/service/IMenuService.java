package com.lrs.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.lrs.admin.entity.Menu;
import com.lrs.admin.util.ParameterMap;

@Component
public interface IMenuService {

	/**
	 * 获取一级菜单，并添加二级菜单
	 * @return
	 */
	public List<Menu> getAllMenuList();
	/**
	 * 获取所有一级菜单
	 * @return
	 */
	public List<Menu> getAllParentMenuList();
	
	/**
	 * 通过一级id获取二级菜单
	 * @param parentId
	 * @return
	 */
	public List<Menu> getSubMenuListByParentId(long parentId);
	/**
	 * 获取菜单表中最大的id
	 * @return
	 */
	public long getMaxId();
	
	/**
	 * 获取二级菜单列表,json格式返回
	 * @param pm
	 * @return
	 */
	public Map<String,Object> getSubMenuList(ParameterMap pm);
	
	/**
	 * 添加菜单
	 * @param pm
	 * @param session
	 * @return
	 */
	public Map<String,Object> addMenu(ParameterMap pm,HttpSession session);
	
	/**
	 * 删除菜单
	 * @param pm
	 * @param session
	 * @return
	 */
	public Map<String,Object> delMenu(String menuId);
	
	/**
	 * 编辑菜单
	 * @param pm
	 * @param session
	 * @return
	 */
	public Map<String,Object> editMenu(ParameterMap pm);
	
	/**
	 * 查询菜单
	 * @param pm
	 * @return
	 */
	public Map<String,Object> findMenu(String menuId);
}
