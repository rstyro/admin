package com.lrs.admin.entity;

public enum PermissionType {
    ADD("add"),             //添加权限
    EDIT("edit"),           //编辑权限
    QUERY("query"),         // 查看权限
    DEL("del");                //删除权限
    private String type;
    private PermissionType(String type){
        this.type=type;
    }
    public String getType() {
        return type;
    }
}
