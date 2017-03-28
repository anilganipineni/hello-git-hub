<%
	// System.out.println("requestURL 1 == " + (request.getRequestURL()).toString());
	// System.out.println("newuRL = " + request.getContextPath() + "/testDispatchAction.action?method=testAction1");

	// response.sendRedirect(request.getContextPath() + "/testDispatchAction.action?method=testAction1");
	response.sendRedirect(request.getContextPath() + "/testDispatchAction.action");
%>
