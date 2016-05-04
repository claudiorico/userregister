<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Library taglibs -->
<%@ include file="taglibs.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  href="<c:url value="/assets/css/jquery-ui.css" />" rel="stylesheet">
<script src="<c:url value="/assets/js/jquery.js" />"></script>
<script src="<c:url value="/assets/js/jquery-ui.min.js" />"></script>

<title>Register new user</title>
</head>
<body>

	<h1>Insert new user</h1>

	<table border:1px solid>

		<form:form action="recordNew" method="post" commandName="newuser">

			<tr>
				<td>Name:</td>
				<td><form:input path="first_name" /></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="last_name" /></td>
			</tr>

			<tr>
				<td>Phone Number:</td>
				<td><form:input path="phone_number" /></td>
			</tr>

			<tr>
				<td>Birth Date:</td>
				<td>
				<c:set var="formatedDate">
					<fmt:formatDate value="${newuser.birth_date.time}"
						pattern="MM/dd/yyyy" />
				</c:set>
				<custom:dateFormat id="birth_date" value="${formatedDate}" />
				</td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" value="New Record"></td>
		</form:form>

	</table>

</body>
</html>