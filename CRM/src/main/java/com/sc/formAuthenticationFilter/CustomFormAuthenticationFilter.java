package com.sc.formAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		
		/*HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String validateCode=(String)session.getAttribute("validateCode");
		String randomcode=req.getParameter("randomcode");
		if(validateCode!=null&&randomcode!=null&&!randomcode.equals(validateCode)){
			req.setAttribute("shiroLoginFailure", "randomCodeError");
			return true;
		}*/
		
		HttpServletRequest req=(HttpServletRequest)request;
		String upass = req.getParameter("upass");
		String uname = req.getParameter("uname");
		String rememberme = req.getParameter("rememberme");
		HttpSession session = req.getSession();
		session.setAttribute("uname", uname);
		session.setAttribute("upass", upass);
		session.setAttribute("rememberme", rememberme);
		return super.onAccessDenied(request, response);
	}
}
