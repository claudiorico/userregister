<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="taglibs.jsp"%>

<html>
<head>

<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserir Registro</title>
</head>
<body>

	<form action="gravarSensorData" method="post">
		<table>
			<tr>
				<td>tagAccX:</td>
				<td><input type="text" name="${sensor.c_tagaccx}" /> <br /></td>
				<td>tagAccY:</td>
				<td><input type="text" name="${sensor.c_tagaccy}" /> <br /></td>
				<td>tagAccZ:</td>
				<td><input type="text" name="${sensor.c_tagaccy}" /> <br /></td>
			</tr>
			<tr>
				<td>tagGyroX:</td>
				<td><input type="text" name="${sensor.c_taggyrox}" /> <br />
				</td>
				<td>tagGyroY:</td>
				<td><input type="text" name="${sensor.c_taggyroy}" /> <br />
				</td>
				<td>tagGyroZ:</td>
				<td><input type="text" name="${sensor.c_taggyroz}" /> <br />
				</td>
			</tr>
			<tr>
				<td>tagMagX:</td>
				<td><input type="text" name="${sensor.c_tagmagx}" /> <br /></td>
				<td>tagMagY:</td>
				<td><input type="text" name="${sensor.c_tagmagy}" /> <br /></td>
				<td>tagMagZ:</td>
				<td><input type="text" name="${sensor.c_tagmagx}" /> <br /></td>
			</tr>
			<tr>
				<td>tagObjTemp:</td>
				<td><input type="text" name="${sensor.c_tagobjtemp}" /> <br />
				</td>
				<td>tagAmbTemp:</td>
				<td><input type="text" name="${sensor.c_tagambtemp}" /> <br />
				</td>
				<td>tagBmp:</td>
				<td><input type="text" name="${sensor.c_tagbmp}" /> <br /></td>
			</tr>
			<tr>
				<td>tagOptical:</td>
				<td><input type="text" name="${sensor.c_tagoptical}" /> <br />
				</td>
			</tr>
		</table>
		<input type="submit" text="Entrar Registro" />
	</form>

</body>
</html>