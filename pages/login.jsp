<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title> Login Page </title>
		<%
			// System.out.println("requestURL in Login 1 == " + (request.getRequestURL()).toString());
		%>
		<script language="JavaScript" type="text/javascript">
			function doLogin() {
				// alert('subbmiting the form................');
				document.loginForm.submit();
				/*
				if (document.loginForm.userName.value == '' || document.loginForm.password.value == '' || document.loginForm.customerId.value == '') {
					document.getElementById('errorSpan').innerHTML = 'Invalid Credentials';
				} else {
					document.loginForm.submit();
				}
				*/
			}
			function onBodyLoad() {
				// alert('On load executed.........');
			}
		</script>

	</head>

	<body onload="onBodyLoad()">
		<b><u><h1> Welocome ..............To............Login Page.......... </h1></u></b>

		<div id="login">
			<form name="loginForm" action='<%= response.encodeURL("j_security_check") %>' method="post">
				<table width="570" border="0" cellpadding="0" cellspacing="0">
					<tr align="center" valign="middle">
						<td width="570" height="30" colspan="7" class="footer_style2" style="color: red; font-size: 15px;">
							<span id="errorSpan">
								<%
									String login = request.getParameter("login");
									if (login != null && login.equals("N")) {
										out.print("Invalid Credentials");
									} else {
										out.print("&nbsp;");
									}
								%>
							</span>
						</td>
					</tr>
					<tr>
						<td width="30">&nbsp;</td>
						<td width="130"><label class="footer_style2">User name:</label><br/><input name="j_username" type="text"/></td>
						
						<td width="20">&nbsp;</td>
						<td width="130"><label class="footer_style2">Password:</label><br/><input name="j_password" type="password"/></td>
					</tr>
					<tr>
						<td width="520" colspan="6">&nbsp;</td>
						<td width="50"><input type="submit" value="Go" onclick="javascript:doLogin()"/></td>
					</tr>
				</table>
				<input type="hidden" name="j_security_check">
			</form>
		</div>

	</body>
</html>
