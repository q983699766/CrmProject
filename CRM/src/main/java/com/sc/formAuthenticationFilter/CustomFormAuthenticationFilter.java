package com.sc.formAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String validateCode=(String)session.getAttribute("validateCode");
		String randomcode=req.getParameter("randomcode");
		if(validateCode!=null&&randomcode!=null&&!randomcode.equals(validateCode)){
			req.setAttribute("shiroLoginFailure", "randomCodeError");
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}
