package com.jsc.ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class TestAction1 extends DispatchAction {
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	public ActionForward testAction1(ActionMapping mapping,
									 ActionForm form,
									 HttpServletRequest request,
									 HttpServletResponse response) {
		
		/*System.out.println("testAction1 executed..............");
		
		System.out.println(" LocalAddr ==> " + request.getLocalAddr());
		System.out.println(" LocalName ==> " + request.getLocalName());
		System.out.println(" LocalPort ==> " + request.getLocalPort());
		System.out.println(" PathInfo ==> " + request.getPathInfo());
		System.out.println(" Protocol ==> " + request.getProtocol());
		System.out.println(" QueryString ==> " + request.getQueryString());
		System.out.println(" RemoteAddr ==> " + request.getRemoteAddr());
		System.out.println(" RemoteHost ==> " + request.getRemoteHost());
		System.out.println(" RemotePort ==> " + request.getRemotePort());
		System.out.println(" RemoteUser ==> " + request.getRemoteUser());
		System.out.println(" RequestURI ==> " + request.getRequestURI());
		System.out.println(" RequestURL ==> " + request.getRequestURL());
		System.out.println(" ServerName ==> " + request.getServerName());
		System.out.println(" ServerPort ==> " + request.getServerPort());
		System.out.println(" ServletPath ==> " + request.getServletPath());
		System.out.println(" UserPrincipal ==> " + request.getUserPrincipal());*/
		
		TestForm aForm = (TestForm) form;
		aForm.setUserId(request.getUserPrincipal().getName());
		
		return mapping.findForward("testAction1");
	}
}
