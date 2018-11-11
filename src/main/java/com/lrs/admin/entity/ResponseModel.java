package com.lrs.admin.entity;

import java.util.HashMap;

public class ResponseModel{

	private static HashMap<String,Object> model=null;
	
	private ResponseModel() {}
	
	public static HashMap<String, Object> getModel(String msg,String status,Object data){
		model = new HashMap<>();
		model.put("msg", msg);
		model.put("status", status);
		model.put("data", data);
		return model;
	}
	
	public static HashMap<String, Object> getModel(ResultEnum resultEnum,Object data){
		model = new HashMap<>();
		model.put("msg", resultEnum.getMsg());
		model.put("status", resultEnum.getStatus());
		model.put("data", data);
		return model;
	}


}
