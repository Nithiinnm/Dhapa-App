<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Express Dhaba</title>
</head>
<body>
<%-- <jsp:include page="navbar.jsp"></jsp:include>> --%>
<%@include file ="navbar.jsp"%>
	<div class="container">
		<h1>Menu items Added</h1>
		Item Name:${addedmenu.itemName}
		<br/>
		Price:${addedmenu.price}
		
	</div>
</body>
</html>