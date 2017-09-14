package com.lrs.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.entity.ReturnModel;
import com.lrs.admin.service.IRoleService;
import com.lrs.admin.util.Jurisdiction;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	
	private String qxurl="role/list";
	
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
	public Object qx(){
		if(!Jurisdiction.buttonJurisdiction(qxurl, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return roleService.getMenu(this.getParameterMap());
	}
	
	/**
	 * 更改角色
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Object edit(){
		if(!Jurisdiction.buttonJurisdiction(qxurl, "edit",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return roleService.edit(this.getParameterMap());
	}
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object add(){
		if(!Jurisdiction.buttonJurisdiction(qxurl, "add",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return roleService.add(this.getParameterMap(),this.getSession());
	}
	/**
	 * 删除角色
	 * @return
	 */
	@RequestMapping(value="/del/{roleId}",method=RequestMethod.GET)
	@ResponseBody
	public Object del(@PathVariable("roleId") String roleId){
		if(!Jurisdiction.buttonJurisdiction(qxurl, "del",this.getSession())){return ReturnModel.getNotAuthModel();} //校验权限
		return roleService.del(roleId);
	}
	
	
}
