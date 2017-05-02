<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<style type="text/css">
#footer {
	background-color: gray;
	color: white;
	clear: both;
	text-align: center;
	padding: 5px;
	margin-top: 10px;
}

#top {
	background-color: #47c3c8;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/js/jquery-1.11.1.js" var="jqueryJs" />
<spring:url value="/js/homepage.js" var="homejs" />
<script type="text/javascript" src="${jqueryJs}"></script>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"> </script>
 <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"> </script>
 

<script type="text/javascript" src="${homejs}">

</script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

</head>
<body>
	<div
		style="background-color: rgb(183, 233, 233); width: 100%; height: 700px"
		align="center">
		<div>
			<div align="right">
				<%
					response.setIntHeader("Refresh", 60);
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();
				%>
				<div style="color: rgb(34, 35, 34); font-size: 20px">
					Welcome Guest |
					<%=dateFormat.format(cal.getTime())%>
				</div>
			</div>
			<div align="left">
				<div align="center" id="top">
					<a href="index">Home</a> | <a href="home">Get a Quota</a>

				</div>
				<div style="color: teal; font-size: 30px">SoftSolutions |
					Insurance</div>
				<div style="color: teal; font-size: 20px">General Insurance
					Company</div>
			</div>
		</div>
		<div></div>

		<div></div>
		<center>
			<div style="color: teal; font-size: 30px">Insurance | Quote
				Form</div>
			<form:form id="zipvalue" modelAttribute="zipBean" method="post"
				action="customer">
				<div align="center">

					<table align="center">
						<tr>

						</tr>
						<tr>
						<td>
						<label>Enter Zip Code</label>
						</td>
							<td><input type="text" id="zipCode" name="zipCode"
								onkeydown="return isNumberKey(event)"
								onkeyup="return checkNumber()"></td>

							<td><input type="text" id="contextpath"
								value=<%=request.getContextPath() %>></td>

						</tr>
						<tr>
							<td id="errorMsgId"><label style="color: red">
									Please Enter Zip Code</label></td>
									
						</tr>
						<tr>
						<td></td>
						
							<td><input type="submit" value="Get Quote"
								onclick="return checkNumber()" /></td>

						</tr>

					</table>
				</div>


			</form:form>

		</center>
		<div></div>
		<div></div>
		<div id="footer">Copyright © SOFT SOLUTIONS</div>
	</div>
</body>
</html>