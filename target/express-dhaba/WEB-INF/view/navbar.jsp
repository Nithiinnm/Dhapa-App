<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="/express-dhaba/bootstraphandler/bootstrap/4.5.3/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Express Dhaba</title>
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous"> -->
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Express Dhaba</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/express-dhaba/showMenuPage">Menu Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/express-dhaba/showAddMenuPage">Add Menu</a></li>
				<li class="nav-item"><a class="nav-link" href="/express-dhaba/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/express-dhaba/customerPage">Create Customer</a></li>
				<li class="nav-item"><a class="nav-link" href="/express-dhaba/orderPage">Take Order</a></li>
				<li class="nav-item"><a class="nav-link" href="/express-dhaba/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

</body>
</html>