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
		<h2>Add a Product to Stock</h2>
	</div>
	<form class="form-horizontal" method="post" action="addItem"
		style="text-align: right;">
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="text" class="form-control" name="title"
						placeholder="Enter Product Title" autocomplete="off"
						value="${Item.title}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="text" class="form-control" name="manufacturer"
						placeholder="Enter Product Manufacturer" autocomplete="off"
						value="${Item.manufacturer}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="text" class="form-control" name="price"
						placeholder="Enter Product Price" autocomplete="off"
						value="${Item.price}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="text" class="form-control" name="category"
						placeholder="Product Category" autocomplete="off"
						value="${Item.category}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="text" class="form-control" name="quantity"
						placeholder="Enter Product Quantity" autocomplete="off"
						value="${Item.quantity}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-4">
				<div class="col-md-5 container">
					<input type="file" class="form-control" name="image"
						value="${Item.image}" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Add To Stock" />
		</div>
	</form>


	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>

</body>
</html>

</body>
</html>