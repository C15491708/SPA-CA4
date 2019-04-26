<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X_UACompatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/admin.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>iStore</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/home">Electronic Store</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor03" aria-controls="navbarColor03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/Aitem">Add
						Stock</a></li>
				<li class="nav-item"><a class="nav-link" href="/Asearch">Search
						Stock</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center">
		<br>
		<h1>Search Results</h1>
		<hr>
		<h3>Sort Results</h3>


		<form class="form-horizontal" method="post" action="adminResults"
			style="text-align: right;">
			<div class="form-group">
				<input type="text" class="form-control col-md-4" name="sortBy"
					autocomplete="off" placeholder="Sort By" list="sb" />
				<datalist id="sb">
					<option value="Title">
					<option value="Manufacturer">
					<option value="Price">
					<option value="Category">
				</datalist>
				<input type="text" class="form-control col-md-4" name="orderList"
					autocomplete="off" placeholder="Order" list="order" />
				<datalist id="order">
					<option value="Ascending Order">
					<option value="Descending Order">
				</datalist>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-secondary" value="Sort" />
			</div>
		</form>
	</div>

	<table>
		<c:forEach var="Item" items="${sessionScope.AdminSearchResult}"
			varStatus="status">
			<c:if test="${not status.first and status.index % 4 == 0}">
				<tr>
			</c:if>
			<td width="200"><img src="images/${Item.photo}"
				height="200" width="180" /><br> <c:out
					value="${Item.title}" /><br> Manufacturer: <c:out
					value="${Item.manufacturer}" /><br> Category: <c:out
					value="${Item.category}" /><br> Price: €<c:out
					value="${Item.price}" /><br> <br> <br></td>
			<c:if test="${status.first and status.index % 4 == 4 or status.last}">
			</c:if>
		</c:forEach>
	</table>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>
