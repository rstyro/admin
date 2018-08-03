package com.lrs.admin.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.druid.util.Base64;
import com.lrs.admin.dao.RoleDao;
import com.lrs.admin.dao.UserDao;
import com.lrs.admin.entity.Const;
import com.lrs.admin.entity.Menu;
import com.lrs.admin.entity.ResponseModel;
import com.lrs.admin.entity.Role;
import com.lrs.admin.entity.User;
import com.lrs.admin.entity.UserRole;
import com.lrs.admin.service.IUserService;
import com.lrs.admin.util.DateUtil;
import com.lrs.admin.util.ImgUtil;
import com.lrs.admin.util.ParameterMap;
import com.lrs.admin.util.RightsHelper;
import com.lrs.admin.util.SHA;
import com.lrs.admin.util.Tools;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private MenuService menuService;
	
	@Value("${upload.root.folder}")
	public String root_fold;
	
	@Value("${img.folder}")
	public String img_fold;
	
	@Value("${user.folder}")
	public String user_folder;
	
	private Logger log = Logger.getLogger(this.getClass());

//	@Autowired
//	private RedisTemplate<String, Object> redis;

	
	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> login(ParameterMap pm, HttpSession session) {
		System.out.println("pm=" + pm);
		try {
			String psw = pm.getString("password");
			String userName = pm.getString("username");
			if(Tools.isEmpty(userName) || Tools.isEmpty(psw)){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			psw = SHA.encryptSHA(psw);
			System.out.println("encode psw=" + psw);
			pm.put("password", psw);
			User user = userDao.getUserInfo(pm);
			
			if("lock".equalsIgnoreCase(user.getStatus())){
				return ResponseModel.getModel("此账号已锁定", "failed", null);
			}
			//获取用户权限
			String userId = user.getUserId();
			pm.put("user_id", userId);
			//获取用户所有角色
			List<Role> uRoles = userDao.getUserRoleList(pm);
			long maxMenuId = menuService.getMaxId();
			UserRole uRole = new UserRole(new BigInteger("0"),new BigInteger("0"),new BigInteger("0"),new BigInteger("0"),new BigInteger("0"));
			checkUserRole(uRoles, uRole, maxMenuId);
			user.setUserRole(uRole);
			List<Menu> oneMenuList = menuService.getAllMenuList();
			checkMenuRole(oneMenuList, uRole.getRights());
			ServletContext servletContext = session.getServletContext();
			Map<String,User> globalUser = (Map<String, User>) servletContext.getAttribute(Const.GLOBAL_SESSION);
			if(globalUser == null){
				globalUser = new HashMap<String, User>();
			}else{
				if(globalUser.containsKey(userName)){
					globalUser.remove(userName);
				}
			}
			user.setSessionId(session.getId());
			user.setPassword("*****");
			globalUser.put(userName, user);
			session.setMaxInactiveInterval(0);
			session.setAttribute(Const.SESSION_ALL_MENU, oneMenuList);
			session.setAttribute(Const.SESSION_USER, user);
			servletContext.setAttribute(Const.GLOBAL_SESSION, globalUser);
			ParameterMap condition = new ParameterMap();
			condition.put("user_id", userId);
			condition.put("sessionId", session.getId());
			userDao.editUser(condition);
			userDao.saveLoginTime(userId);
			
		}catch (Exception e) {
			e.printStackTrace();
			log.error("login error :" + e.getMessage(), e);
			return ResponseModel.getModel("登录错误，请稍后重试", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}

	@Override
	public String logout(HttpSession session) {
		session.removeAttribute(Const.SESSION_ALL_MENU);
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(Const.SESSION_QX);
		return "login";
	}
	
	@Override
	public List<ParameterMap> getUserList(){
		return userDao.getUserList();
	}
	

	@Override
	public HashMap<String, Object> getRole(ParameterMap pm) {
		List<ParameterMap> roles = null;
		try {
			String userId = pm.getString("user_id");
			if(Tools.isEmpty(userId)){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			roles = roleDao.list();
			List<ParameterMap> uroles = roleDao.getRoleByuId(pm);
			for(ParameterMap role:roles){
				String roleId = role.getString("role_id");
				for(ParameterMap ur:uroles){
					String urid = ur.getString("role_id");
					if(urid.equals(roleId)){
						role.put("checked", true);
						break;
					}else{
						role.put("checked", false);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error:"+e.getMessage(), e);
			return ResponseModel.getModel("获取失败", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", roles);
	}
	
	@Override
	public HashMap<String, Object> add(ParameterMap pm) {
		try {
			String password = pm.getString("password");
			if(Tools.isEmpty(pm.getString("username")) || Tools.isEmpty(password)){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			pm.remove("password");
			pm.put("psw", SHA.encryptSHA(password));
			User user = userDao.getUserInfo(pm);
			if(user != null && !Tools.isEmpty(user.getUserId())){
					return ResponseModel.getModel("用户已存在", "falied", null);
			}
			String pics = pm.getString("pics");
			if(Tools.notEmpty(pics)){
				pics = replaceBase64Before(pics);
				byte[] bytes = Base64.base64ToByteArray(pics);
				InputStream in = new ByteArrayInputStream(bytes);
				String filePath = user_folder+Tools.random(8)+".png";
				String userPath = ImgUtil.uploadImg(root_fold,filePath, in);
				pm.put("pic_path", userPath);
			}
			pm.put("create_time", DateUtil.getTime());
			userDao.saveUser(pm);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error("error:"+e.getMessage(), e);
			return ResponseModel.getModel("提交失败", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}

	@Override
	public HashMap<String, Object> edit(ParameterMap pm) {
		try {
			if(Tools.isEmpty(pm.getString("user_id"))){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			String password = pm.getString("password");
			if(Tools.notEmpty(password)){
				pm.put("password", SHA.encryptSHA(password));
			}
			String pics = pm.getString("pics");
			if(Tools.notEmpty(pics)){
				pics = replaceBase64Before(pics);
				byte[] bytes = Base64.base64ToByteArray(pics);
				InputStream in = new ByteArrayInputStream(bytes);
				String filePath = user_folder+Tools.random(8)+".png";
				String userPath = ImgUtil.uploadImg(root_fold,filePath, in);
				pm.put("pic_path", userPath);
				
				String oldPath = pm.getString("oldpath");
				if(Tools.isEmpty(oldPath)){
					return ResponseModel.getModel("你请求的是冒牌接口", "falied", null); 
				}
				if(!"/images/logo.png".equals(oldPath)){
					//删除旧头像
					oldPath = oldPath.replaceAll("/upload/show","");
					File file = new File(root_fold+oldPath);
					if(file.isFile()){
						file.delete();
					}
				}
			}
			userDao.editUser(pm);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error("error:"+e.getMessage(), e);
			return ResponseModel.getModel("提交失败", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
	@Override
	public HashMap<String, Object> editRole(ParameterMap pm) {
		try {
			if(Tools.isEmpty(pm.getString("user_id"))){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			String ids = pm.getString("ids");
			String userId = pm.getString("user_id");
			List<ParameterMap> parame = null;
			if(Tools.notEmpty(ids)){
				parame = new ArrayList<>();
				String[] roleIds = ids.split(",");
				for(String roleId:roleIds){
					ParameterMap data = new ParameterMap();
					data.put("user_id", userId);
					data.put("role_id", roleId);
					parame.add(data);
				}
			}
			userDao.delUserRole(userId);
			if(parame != null && parame.size() > 0){
				userDao.bathSaveUserRole(parame);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("error:"+e.getMessage(), e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return ResponseModel.getModel("更新失败", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}

	@Override
	public HashMap<String, Object> del(ParameterMap pm) {
		try {
			String userId = pm.getString("user_id");
			String userPath = pm.getString("pic_path");
			if(Tools.isEmpty(userId) || Tools.isEmpty(userPath)){
				return ResponseModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			userDao.delUser(userId);
			userDao.delUserRole(userId);
			if(!"/images/logo.png".equals(userPath)){
				//删除旧头像
				userPath = userPath.replaceAll("/upload/show","");
				File file = new File(root_fold+userPath);
				if(file.isFile()){
					file.delete();
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			log.error("error:"+e.getMessage(), e);
			return ResponseModel.getModel("提交失败", "failed", null);
		}
		return ResponseModel.getModel("ok", "success", null);
	}
	
	/**
	 * 验证权限
	 * 
	 * @param oneMenuList
	 *            总菜单
	 * @param rights
	 *            用户权限值
	 */
	public void checkMenuRole(List<Menu> oneMenuList, BigInteger rights) {
		for (Menu m : oneMenuList) {
			m.setHasMenu(RightsHelper.testRights(rights, m.getMENU_ID()));
			if (m.isHasMenu()) {
				List<Menu> subList = m.getSubMenu();
				for (Menu subM : subList) {
					subM.setHasMenu(RightsHelper.testRights(rights, subM.getMENU_ID()));
				}
			}
		}
	}
	
	/**
	 * 把用户拥有的角色权限合并起来
	 * @param uRoles
	 * @param uRole
	 * @param maxMenuId
	 */
	public void checkUserRole(List<Role> uRoles,UserRole uRole,long maxMenuId){
		if(uRoles == null){return;}
		for(int i=0;i<uRoles.size();i++){
			BigInteger right = new BigInteger(uRoles.get(i).getRights());
			BigInteger aqx = new BigInteger(uRoles.get(i).getAddQX());
			BigInteger dqx = new BigInteger(uRoles.get(i).getDelQX());
			BigInteger eqx = new BigInteger(uRoles.get(i).getEditQX());
			BigInteger qqx = new BigInteger(uRoles.get(i).getQueryQX());
			for(int j=0;j<=maxMenuId;j++){
				if(right.testBit(j)){
					uRole.setRights(uRole.getRights().setBit(j));
				}
				if(aqx.testBit(j)){
					uRole.setAdds_qx(uRole.getAdds_qx().setBit(j));
				}
				if(dqx.testBit(j)){
					uRole.setDels_qx(uRole.getDels_qx().setBit(j));
				}
				if(eqx.testBit(j)){
					uRole.setEdits_qx(uRole.getEdits_qx().setBit(j));
				}
				if(qqx.testBit(j)){
					uRole.setQuerys_qx(uRole.getQuerys_qx().setBit(j));
				}
			}
		}
	}
	
	/**
	 * 替换base64的前缀
	 * @param pics
	 * @return
	 */
	public static String replaceBase64Before(String pics){
		pics = pics.replace("data:image/png;base64,", "");
		pics = pics.replace("data:image/jpeg;base64,", "");
		pics = pics.replace("data:image/bmp;base64,", "");
		pics = pics.replace("data:image/x-icon;base64,", "");
		pics = pics.replace("data:image/gif;base64,", "");
		return pics;
	}

	@Override
	public User getUserInfo(ParameterMap pm) {
		return userDao.getUserInfo(pm);
	}
	
}
