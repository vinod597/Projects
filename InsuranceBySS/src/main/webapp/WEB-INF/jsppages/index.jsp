<%@page import="java.util.Calendar"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/js/jquery-1.11.1.js" var="jqueryJs" />

<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/styles/stylesheet.css" />" />
</head>
<body>
<div style="background-color: rgb(183, 233, 233); width: 100% ; height: 700px" align="center">
<div>
<div align="right">
<%
response.setIntHeader("Refresh", 15);
DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Calendar cal = Calendar.getInstance();
%>
<div style="color: rgb(34, 35, 34); font-size: 20px">Welcome Guest |  <%=dateFormat.format(cal.getTime()) %>
       </div>
</div>
<div align="left">
<div>
	<div style="color: teal; font-size: 30px">SoftSolutions |  
       Insurance</div>
       <div style="color: teal; font-size: 20px">General Insurance Company</div>
       </div>
	</div>
	<div align="center" id="top">
<a href="index">Home</a> | <a href="home">Get a Quota</a>

</div>
	</div>
	
	
<div align="center">
<a href="home">
<img src="<c:url value="/images/homePic.jpg"/>" style="float:center; width:638px; height:300px;">
</a>
</div>
<div>

</div>
<div id="footer">
Copyright © SOFT SOLUTIONS
</div>
</div>


</body>
</html>