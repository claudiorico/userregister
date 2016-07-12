<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp"%>

<html>
<head>

<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript" src="assets/js/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Registro</title>

<script type="text/javascript">

function getNumber(){
	return Math.floor((Math.random() * 100) + 1);
}

function setValue(){
	document.getElementById("c_tagaccx").value = getNumber();
	document.getElementById("c_tagaccy").value = getNumber();
	document.getElementById("c_tagaccz").value = getNumber();
	document.getElementById("c_taggyrox").value = getNumber();
	document.getElementById("c_taggyroy").value = getNumber();
	document.getElementById("c_taggyroz").value = getNumber();
	document.getElementById("c_tagmagx").value = getNumber();
	document.getElementById("c_tagmagy").value = getNumber();
	document.getElementById("c_tagmagz").value = getNumber();
	document.getElementById("c_tagobjtemp").value = getNumber();
	document.getElementById("c_tagambtemp").value = getNumber();
	document.getElementById("c_tagbmp").value = getNumber();
	document.getElementById("c_tagoptical").value = getNumber();
}

//$(document).ready(setValue())

</script>

</head>
<body onload="setValue()">

	<table>

		<form:form action="gravarSensorData" method="post"
			commandName="sensor">

			<tr>
				<td>tagAccX:</td>
				<td><form:input path="c_tagaccx" /></td>
				<td>tagAccY:</td>
				<td><form:input path="c_tagaccy" /></td>
				<td>tagAccZ:</td>
				<td><form:input path="c_tagaccz" /></td>
			</tr>

			<tr>
				<td>tagGyroX:</td>
				<td><form:input path="c_taggyrox" /></td>
				<td>tagGyroY:</td>
				<td><form:input path="c_taggyroy" /></td>
				<td>tagGyroZ:</td>
				<td><form:input path="c_taggyroz" /></td>
			</tr>

			<tr>
				<td>tagMagX:</td>
				<td><form:input path="c_tagmagx" /></td>
				<td>tagMagY:</td>
				<td><form:input path="c_tagmagy" /></td>
				<td>tagMagZ:</td>
				<td><form:input path="c_tagmagz" /></td>
			</tr>
			<tr>
				<td>tagObjTemp:</td>
				<td><form:input path="c_tagobjtemp" /> <br />
				</td>
				<td>tagAmbTemp:</td>
				<td><form:input path="c_tagambtemp" /> <br />
				</td>
				<td>tagBmp:</td>
				<td><form:input path="c_tagbmp" /> <br /></td>
			</tr>
			<tr>
				<td>tagOptical:</td>
				<td><form:input path="c_tagoptical" /> <br />
				</td>
			</tr>			
			<br />
			<tr>
				<td colspan=2><input type="submit" text="Entrar Registro">
			</td>
		</form:form>

	</table>

</body>
</html>