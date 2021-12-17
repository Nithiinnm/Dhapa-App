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
<!--  <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous"> -->

</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h1>Menu items</h1>
		<form action="searchMenuItem" method="get">
			<input type="text" name="itemName"> <input type="submit"
				value="Search">
		</form>
		<table class="table .thead-light">
			<thead>
				<tr>
					<th>Id</th>
					<th>Item Name</th>
					<th>Price</th>
					<!-- <th>Description</th>
					<th>Type</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempMenu" items="${menu}" varStatus="vs">
					<tr>
						<td>${tempMenu.id}</td>
						<td>${tempMenu.itemName}</td>
						<td>${tempMenu.price}</td>
						<%-- <td>${tempMenu.menuDetails.desc}</td>
						<td>${tempMenu.menuDetails.type}</td> --%>
						<td>
							<!-- Button trigger modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal${vs.index}">Info</button>
								 <!-- Modal Header -->
							<div class="modal fade" id="exampleModal${vs.index}" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">
												Item Description</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
									Description:	${tempMenu.menuDetails.desc}<br/>
									Type:	${tempMenu.menuDetails.type}
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div> <a href="/express-dhaba/updateMenuItem/${tempMenu.id}">Update</a>
							<a href="/express-dhaba/deleteMenuItem?itemid=${tempMenu.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript"
		src="/express-dhaba/bootstraphandler/jquery/3.5.1/jquery.slim.min.js"></script>
	<script type="text/javascript"
		src="/express-dhaba/bootstraphandler/popper.js/1.16.0/umd/popper.min.js"></script>
	<script type="text/javascript"
		src="/express-dhaba/bootstraphandler/bootstrap/4.5.3/js/bootstrap.min.js"></script>
</body>
</html>