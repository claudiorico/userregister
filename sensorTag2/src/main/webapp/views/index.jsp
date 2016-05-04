<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="taglibs.jsp"%>

<html>
<head>
<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<!-- begin the header for the application -->
<title><spring:message code="login.title" /></title>
<!-- end of header -->
</head>
<body>
	<!-- begin the logo for the application -->
	<c:import url="logo.jsp" />
	<!-- end of logo -->
	<br />

	<table width="100%">
		<tr valign="top" align="center">
			<td>
				<form action="apresentacao" method="post">
					<br /> <input type="submit" value="Monitor">
				</form>
			</td>
		</tr>
	</table>
	
	<br />
	<c:import url="rodape.jsp" />

</body>
</html>
