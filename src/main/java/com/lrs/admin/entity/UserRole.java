package com.lrs.admin.entity;

import java.math.BigInteger;
/**
 * 用户的最后拥有的角色
 * @author tyro
 *
 */
public class UserRole {
	private BigInteger rights;
	private BigInteger adds_qx;
	private BigInteger edits_qx;
	private BigInteger dels_qx;
	private BigInteger querys_qx;
	public BigInteger getRights() {
		return rights;
	}
	public void setRights(BigInteger rights) {
		this.rights = rights;
	}
	public BigInteger getAdds_qx() {
		return adds_qx;
	}
	public void setAdds_qx(BigInteger adds_qx) {
		this.adds_qx = adds_qx;
	}
	public BigInteger getEdits_qx() {
		return edits_qx;
	}
	public void setEdits_qx(BigInteger edits_qx) {
		this.edits_qx = edits_qx;
	}
	public BigInteger getDels_qx() {
		return dels_qx;
	}
	public void setDels_qx(BigInteger dels_qx) {
		this.dels_qx = dels_qx;
	}
	public BigInteger getQuerys_qx() {
		return querys_qx;
	}
	public void setQuerys_qx(BigInteger querys_qx) {
		this.querys_qx = querys_qx;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(BigInteger rights, BigInteger adds_qx, BigInteger edits_qx, BigInteger dels_qx,
			BigInteger querys_qx) {
		super();
		this.rights = rights;
		this.adds_qx = adds_qx;
		this.edits_qx = edits_qx;
		this.dels_qx = dels_qx;
		this.querys_qx = querys_qx;
	}
	@Override
	public String toString() {
		return "UserRole [rights=" + rights + ", adds_qx=" + adds_qx + ", edits_qx=" + edits_qx + ", dels_qx=" + dels_qx
				+ ", querys_qx=" + querys_qx + "]";
	}
	
	
	
}
