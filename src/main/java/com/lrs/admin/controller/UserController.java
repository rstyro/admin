package com.lrs.admin.controller;

import com.lrs.admin.annotation.Permission;
import com.lrs.admin.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lrs.admin.controller.base.BaseController;
import com.lrs.admin.service.IUserService;
import com.lrs.admin.util.Jurisdiction;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	private final  static String qxurl = "user/list";
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@Permission(url = qxurl,type = PermissionType.QUERY)
	public Object login(Model model){
		model.addAttribute("users", userService.getUserList());
		model.addAttribute("meid", ((User)this.getSession().getAttribute(Const.SESSION_USER)).getUserId());
		return "page/user/list";
	}
	
	/**
	 * 获取用户角色
	 * @return
	 */
	@RequestMapping(value="/getRole",method=RequestMethod.GET)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.EDIT)
	public Object userRole(){
		return userService.getRole(this.getParameterMap());
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.ADD)
	public Object add(){
		return userService.add(this.getParameterMap());
	}
	
	
	/**
	 * 编辑用户
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.EDIT)
	public Object edit(){
		return userService.edit(this.getParameterMap());
	}
	
	/**
	 * 编辑用户
	 * @return
	 */
	@RequestMapping(value="/editRole",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.EDIT)
	public Object editRole(){
		return userService.editRole(this.getParameterMap());
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	@ResponseBody
	@Permission(url = qxurl,type = PermissionType.DEL)
	public Object del(){
		return userService.del(this.getParameterMap());
	}
	
	
}
