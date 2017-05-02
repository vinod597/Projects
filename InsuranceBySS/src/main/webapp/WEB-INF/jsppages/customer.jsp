<%@page import="com.insurance.bean.CustomerBean"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.insurance.bean.ZipBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Customer | Home</title>
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

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js">
	
</script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.10.3/jquery-ui.js">
	
</script>


<script type="text/javascript" src="${homejs}">
	
</script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

</head>
<body>
	<div
		style="background-color: rgb(183, 233, 233); width: 100%; height: 700px"
		align="center">
		<div>
			<div align="right">
				<%
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Calendar cal = Calendar.getInstance();

					ZipBean zipBean = (ZipBean) request.getAttribute("zipCode");
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
			<div style="color: teal; font-size: 30px">Insurance | Customer
				Form</div>
			<form:form modelAttribute="customerBean" id="customerBean">
				<table align="center">
					<tr>
						<td><label>First Name</label></td>
						<td><input type="text" name="fname"></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><input type="text" name="lname"></td>
					</tr>
					<tr>
						<td><label>Address</label></td>
						<td><input type="text" name="addresss"></td>

					</tr>
					<tr>
						<td><label>Zip code</label></td>
						<td><input type="text" name="zipCode" id="zipCode"
							value=<%=zipBean.getZipCode()%>
							onkeydown="return getZipValues('<%=request.getContextPath()%>/HomeAjax/getData')"
							onblur="return getZipValues('<%=request.getContextPath()%>/HomeAjax/getData')"></td>
						<td><input type="text" id="contextpath"
							value=<%=request.getContextPath()%>></td>
						<td><label id="errorZip"></label></td>
					</tr>
					<tr>
						<td><label>city</label></td>
						<td><input type="text" name="cityName" id="cityName"
							value=<%=zipBean.getCityName()%> disabled="disabled"></td>
					</tr>
					<tr>
						<td><label>state</label></td>
						<td><input type="text" name="stateName" id="stateName"
							value=<%=zipBean.getStateName()%> disabled="disabled"></td>
					</tr>
					<tr>
						<td><label>Date of birth</label></td>
						<td><input type="text" name="dob"></td>
					</tr>
					<tr>
						<td>Select 'Yes' if ANY of the following apply to you:</td>
					</tr>

					<tr>
						<td>I need to insure more than one driver</td>
						<td><input type="radio" name="val" value="yes">Yes <input
							type="radio" name="val" value="no">No</td>
					</tr>

					<tr>
						<td>I need to insure more than one vechicle</td>
					</tr>
					<tr>
						<td>l am married</td>


					</tr>
					<tr>
						<td><input type="submit" name="submit" value="continue">
				</table>
			</form:form>
		</center>
		<div></div>
		<div></div>
		<div id="footer">Copyright © SOFT SOLUTIONS</div>
	</div>
</body>
</html>
