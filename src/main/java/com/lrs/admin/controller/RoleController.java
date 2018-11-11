package com.lrs.admin.controller;

import com.lrs.admin.annotation.Permission;
import com.lrs.admin.entity.PermissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.entity.ResultEnum;
import com.lrs.admin.service.IRoleService;
import com.lrs.admin.util.Jurisdiction;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	
	private final static String qxurl="role/list";
	
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list(Model model){
		model.addAttribute("roles", roleService.list());
		return "page/role/list";
	}
	
	/**
	 * 获取权限
	 * @return
	 */
	@RequestMapping(value="/qx",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.ADD)
	public Object qx(){
		return roleService.getMenu(this.getParameterMap());
	}
	
	/**
	 * 更改角色
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.EDIT)
	public Object edit(){
		return roleService.edit(this.getParameterMap());
	}
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.ADD)
	public Object add(){
		return roleService.add(this.getParameterMap(),this.getSession());
	}
	/**
	 * 删除角色
	 * @return
	 */
	@RequestMapping(value="/del/{roleId}",method=RequestMethod.GET)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.DEL)
	public Object del(@PathVariable("roleId") String roleId){
		return roleService.del(roleId);
	}
	
	
}
