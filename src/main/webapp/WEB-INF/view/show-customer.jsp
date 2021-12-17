<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<div class="container">
		<jsp:include page="navbar.jsp"></jsp:include>
		<h3>Add Customer Details</h3>

		<form:form action="save-customer" method="POST"
			modelAttribute="customerAtt">
Customer Name:<form:input path="name" />
			<br />
Mobile No :<form:input path="mobile" />
			<br />
Address :<form:input path="address" />
			<br />
			<input type="submit">
		</form:form>
	</div>
</body>
</html>