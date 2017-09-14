package com.lrs.admin.entity;

import java.util.HashMap;

import com.lrs.admin.util.Tools;

public class ReturnModel{

	private static HashMap<String,Object> model=null;
	
	private ReturnModel() {}
	
	public static HashMap<String, Object> getModel(String msg,String status,Object data){
		if(model == null){
			model = new HashMap<>();
		}
		if(Tools.notEmpty(msg)){
			model.put("msg", msg);
		}
		if(Tools.notEmpty(status)){
			model.put("status", status);
		}
		if(data != null){
			model.put("data", data);
		}else{
			model.put("data", null);
		}
		return model;
	}
	
	public static HashMap<String, Object> getErrorModel(){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "failed");
		model.put("msg", "你请求的是一个冒牌接口");
		return model;
	}
	public static HashMap<String, Object> getNotAuthModel(){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "notauth");
		model.put("msg", "你权限不足");
		return model;
	}
}
