package com.lrs.admin.entity;

/**
 * 角色
 * @author tyro
 *
 */
public class Role {
	private long roleId;
	private String roleName;
	private String roleDesc;
	private String rights;
	private String addQX;
	private String delQX;
	private String editQX;
	private String queryQX;
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getAddQX() {
		return addQX;
	}
	public void setAddQX(String addQX) {
		this.addQX = addQX;
	}
	public String getDelQX() {
		return delQX;
	}
	public void setDelQX(String delQX) {
		this.delQX = delQX;
	}
	public String getEditQX() {
		return editQX;
	}
	public void setEditQX(String editQX) {
		this.editQX = editQX;
	}
	public String getQueryQX() {
		return queryQX;
	}
	public void setQueryQX(String queryQX) {
		this.queryQX = queryQX;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(long roleId, String roleName, String roleDesc, String rights, String addQX, String delQX,
			String editQX, String queryQX) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.rights = rights;
		this.addQX = addQX;
		this.delQX = delQX;
		this.editQX = editQX;
		this.queryQX = queryQX;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", rights=" + rights
				+ ", addQX=" + addQX + ", delQX=" + delQX + ", editQX=" + editQX + ", queryQX=" + queryQX + "]";
	}
	
	
	
}
