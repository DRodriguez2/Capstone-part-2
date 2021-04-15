<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    
</head>

<body>
	<div class="container">
		<h1 class="display-3">Administrator Page</h1>
		<p>This is the administrator page!</p>
		<hr class="featurette-divider">
		<div class="row">
			<div class="col-7"><h2 class="display-4" th:inline="text">Welcome admin: [[${user.username}]]</h2></div>
			<div class="col">
				<form class="form-signin" method="get" action="/logout">
        		<button class="btn btn-danger btn-block" type="submit" style="width:100%">Logout</button>
    		</form>
			</div>
			<div class="col"></div>
		</div>
		
		<hr class="featurette-divider">
		
		<a class="btn btn-link btn-lg" href="/admin/products" role="button">Product Inventory</a></br>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Here you can view, check and modify the product inventory!</p>
		
		<a class="btn btn-link btn-lg" href="/admin/customers" role="button">Customer Management</a></br>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Here you can view customer Information</p>
	</div>
	<footer class="footer">
      <div class="container">
        <span class="text-muted"> &nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
</body>
</html>