package com.lrs.admin.entity;

import java.util.List;

/**
 * 
 * @author tyro
 *
 */
public class Menu {
	private long MENU_ID;
	private long PARENT_ID;
	private String MENU_NAME;
	private String MENU_URL;
	private String MENU_TYPE;
	private String MENU_ICON;
	private String MENU_ORDER;
	
	//子菜单
	private List<Menu> subMenu;
	
	private boolean hasMenu = false;
	
	public long getMENU_ID() {
		return MENU_ID;
	}

	public void setMENU_ID(long mENU_ID) {
		MENU_ID = mENU_ID;
	}

	public long getPARENT_ID() {
		return PARENT_ID;
	}

	public void setPARENT_ID(long pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}

	public String getMENU_NAME() {
		return MENU_NAME;
	}

	public void setMENU_NAME(String mENU_NAME) {
		MENU_NAME = mENU_NAME;
	}

	public String getMENU_URL() {
		return MENU_URL;
	}

	public void setMENU_URL(String mENU_URL) {
		MENU_URL = mENU_URL;
	}

	public String getMENU_TYPE() {
		return MENU_TYPE;
	}

	public void setMENU_TYPE(String mENU_TYPE) {
		MENU_TYPE = mENU_TYPE;
	}

	public String getMENU_ICON() {
		return MENU_ICON;
	}

	public void setMENU_ICON(String mENU_ICON) {
		MENU_ICON = mENU_ICON;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
	

	public String getMENU_ORDER() {
		return MENU_ORDER;
	}

	public void setMENU_ORDER(String mENU_ORDER) {
		MENU_ORDER = mENU_ORDER;
	}

	@Override
	public String toString() {
		return "Menu [MENU_ID=" + MENU_ID + ", PARENT_ID=" + PARENT_ID + ", MENU_NAME=" + MENU_NAME + ", MENU_URL="
				+ MENU_URL + ", MENU_TYPE=" + MENU_TYPE + ", MENU_ICON=" + MENU_ICON + ", MENU_ORDER=" + MENU_ORDER
				+ ", subMenu=" + subMenu + ", hasMenu=" + hasMenu + "]";
	}


	

}
