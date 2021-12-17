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

	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Take Order</h1>

		<form:form action="save-order" method="POST"
			modelAttribute="order">
			<h3>Customer Details</h3>
			<label>Customer Name</label>
			<form:input path="customer.name" />
			<br />
			<label>Mobile No </label>
			<form:input path="customer.mobile" />
			<br />
			<label>Address </label>
			<form:input path="customer.address" />
			<br />
			<h3>Order Details</h3>
			<label>Choose Menu Item</label>
			<form:select path="menuid.id">
			<%-- <form:option value="no">---Select---</form:option> --%>
			<form:options items="${ListofMenu}" itemLabel="itemName"  itemValue="id"/>
			</form:select>
			<br/>
			<label>Order Type</label>
			<form:select path="ordertype">
			<form:option value="no">----Select----</form:option>
			<form:option value="dining">Dining</form:option>
			<form:option value="takeway">Take away</form:option>
			</form:select>
			<br/>
			<label>Quantity</label>
			<form:input path="quantity" />
			<br/>
			<label>Date</label>
			<form:input path="date"/>
			<br/>
			<input type="submit">
		</form:form>
	</div>
</body>
</html>