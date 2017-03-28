<%
	String originalUrl = request.getRequestURL().toString();
	String localHostUrl = originalUrl.substring(0, originalUrl.indexOf(request.getContextPath()));
	
	String jsecUrl = localHostUrl + "/example_j_security_check";
	String sso1Url = localHostUrl + "/sso1";
	String sso2Url = localHostUrl + "/sso2";
	String sso3Url = localHostUrl + "/sso3";
	
	// System.out.println("requestURL in App == " + originalUrl);
	// System.out.println("sso1Url == " + sso1Url);

	// System.out.println("newuRL = " + request.getContextPath() + "/testDispatchAction.action?method=testAction1");

	// response.sendRedirect(request.getContextPath() + "/testDispatchAction.action?method=testAction1");
	// response.sendRedirect(request.getContextPath() + "/testDispatchAction.action");
%>

<script language="JavaScript" type="text/javascript">
	
	function redirectToGivenUrl(newUrl) {
		window.location.replace(newUrl);
	}
</script>


<table>
	<tr>
		<td><button onclick="redirectToGivenUrl('<%=jsecUrl%>')">App 0</button></td>
		<td><button onclick="redirectToGivenUrl('<%=sso1Url%>')">App 1</button></td>
		<td><button onclick="redirectToGivenUrl('<%=sso2Url%>')">App 2</button></td>
		<td><button onclick="redirectToGivenUrl('<%=sso3Url%>')">App 3</button></td>
	</tr>
</table>