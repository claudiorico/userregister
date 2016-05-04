<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="taglibs.jsp"%>

<html>
<head>
<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/bootstrap-theme.min.css" rel="stylesheet">

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/sensortag.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>

<title><spring:message code="apresentacao.title" /></title>

<script type="text/javascript">
	printList();
</script>



</head>
<body>

	<div class="container">

		<!-- begin the logo for the application -->
		<c:import url="logo.jsp" />
		<!-- end of logo -->
		<br />

		<div class="alert alert-danger alert-dismissible" role="alert"
			id="msgid1" hidden="true">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>
				<div id="msg1"></div>
			</strong>
		</div>

		<div class="alert alert-danger alert-dismissible" role="alert"
			id="msgid2" hidden="true">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>
				<div id="msg2"></div>
			</strong>
		</div>

		<div class="alert alert-danger alert-dismissible" role="alert"
			id="msgid3" hidden="true">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close" width="200">
				<span aria-hidden="true">×</span>
			</button>
			<strong>
				<div id="msg3"></div>
			</strong>
		</div>

		<table>
			<tr>
				<td align="center">
					<h4>Sensores</h4> <br>
					<div id="chart_div"></div>
				</td>
			</tr>
			<tr>
				<td align="center">
					<h4>Temperatura do Objeto</h4> <br>
					<div id="linechart_material"></div>
				</td>
			</tr>

		</table>

	</div>

	<br />
	<c:import url="rodape.jsp" />

</body>

</html>