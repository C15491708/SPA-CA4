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
				<li class="nav-item"><a class="nav-link" href="/search">Products</a></li>
				<li class="nav-item"><a class="nav-link" href="/userCart">Shopping
						Cart</a></li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container text-center">
		<br>
		<h4>Welcome ${sessionScope.user.firstName }</h4>
		<hr>
	</div>


	<form class="form-horizontal" method="post" action="UserSearch"
		style="text-align: right;">
		<br> <b>Filter</b><br> <input type="checkbox"
			name="category" value="Category"><b>Category</b> <input
			type="checkbox" name="manufacturer" value="Manufacturer"><b>Manufacturer</b>
		<input type="checkbox" name="title" value="Title"><b>Title</b>

		<div class="form-group">
			<div class="col-md-offset-4">
				<br> <label class="col-md-3  control-label"><b>User
						Search</b></label><br>
				<div class="col-md-3 container">
					<input type="text" class="form-control" name="search" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-secondary" value="Search" />
		</div>
	</form>

	<script src="static/js/jquery.min.js"></script>
	<script src="static/js/bootstrap.js"></script>
	<script src="static/js/npm.js"></script>



</body>
</html>