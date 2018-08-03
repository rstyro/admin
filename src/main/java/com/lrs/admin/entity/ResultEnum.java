package com.lrs.admin.entity;

public enum ResultEnum {
	SUCCESS("200","success"),
	NOT_AUTH("403","not auth"),
	FAILED("400", "failed"),
	ERROR("500", "ERROR"),
	;
	private String status;
	private String msg;
	private ResultEnum(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}
	
}
