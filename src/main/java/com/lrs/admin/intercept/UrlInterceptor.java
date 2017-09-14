package com.lrs.admin.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lrs.admin.entity.Const;
import com.lrs.admin.entity.User;
import com.lrs.admin.util.Jurisdiction;

public class UrlInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
		//添加增删改查权限
		if(mv != null){
			mv.addObject(Const.SESSION_QX, request.getSession().getAttribute(Const.SESSION_QX));
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		try {
			HttpSession session = request.getSession();
			String path = request.getServletPath();
			System.out.println("path="+path);
			User user =  (User) session.getAttribute(Const.SESSION_USER);
			if(null == user || "".equals(user)){
				response.sendRedirect("/");
				return false;
			}else{
				path = path.substring(1, path.length());
				boolean b = Jurisdiction.hasJurisdiction(path,session);
				if(!b){
					response.sendRedirect("/error/404");
					return b;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
