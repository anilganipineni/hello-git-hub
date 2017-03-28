package com.jsc.ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TestAction extends Action {

	/**
	 * @see org.apache.struts.action.Action#
	 * execute(org.apache.struts.action.ActionMapping, 
	 * 		   org.apache.struts.action.ActionForm,
	 * 		   javax.servlet.http.HttpServletRequest,
	 * 		   javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) throws Exception {

		/*System.out.println("TestAction.execute() executed..............");
		
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
