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
		<h4>Welcome Admin</h4>
		<hr>
	</div>
	
	<div class="container text-center">
		<h1>Our Products</h1>
	</div> 

	<sql:setDataSource var="djs" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/SPAca4" user="root" password="root" />
	<sql:query dataSource="${djs }" sql="select * from Item"
		var="products" />

	<table>
		<c:forEach var="Item" items="${products.rows}" varStatus="status">
			<c:if test="${not status.first and status.index % 4 == 0}">
				<tr>
			</c:if>
			<td width="220"><img src="images/${Item.photo}"
				height="250" width="200" /><br> <c:out
					value="${Item.title}" /><br> Manufacturer: <c:out
					value="${Item.manufacturer}" /><br> Category: <c:out
					value="${Item.category}" /><br> Price: €<c:out
					value="${Item.price}" /><br> <c:choose>
					<c:when test="${!Item.state}">Out of Stock</c:when>
					<c:when test="${Item.state}">
						<form class="form-horizontal" method="post" action="updateShoppingCart">
							<div class="form-group">
								<input type="hidden" name="itemId" value="${Item.good_id}" />
								<input type="submit" class="btn btn-primary btn-sm"
									value="ADD" />
							</div>
						</form>
					</c:when>
				</c:choose> <br> <br></td>
			<c:if test="${status.first and status.index % 4 == 4 or status.last}">
			</c:if>
		</c:forEach>
	</table>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>
</body>
</html>