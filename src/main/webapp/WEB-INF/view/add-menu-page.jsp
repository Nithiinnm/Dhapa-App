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
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Take Order</h1>
		<form:form action="/express-dhaba/save-menu" method="POST" modelAttribute="addmenu">
		
		<form:hidden path="id"/>
		<br/>
		<h3>Menu</h3>
		<label>Item Name</label>
		<form:input path="itemName"/>
		<br/>
		<label>Price</label>
		<form:input path="price"/>
		<br/>
		<h3>Menu Details</h3>
		<label>Description</label>
		<form:input path="menuDetails.desc"/>
		<br/>
		<label>Type</label>
		<form:input path="menuDetails.type"/>
		<br/>
		<input type="Submit" value="AddMenu">
		</form:form>
	</div>
</body>
</html>