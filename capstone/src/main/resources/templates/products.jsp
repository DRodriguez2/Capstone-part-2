<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome Home</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-3">Product Inventory Page</h1>
		<p>This is the product inventory page!</p>
		<hr class="featurette-divider">
		
		<a class="btn btn-link btn-lg" href="/admin/products1" role="button">Products</a></br>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Here you can view,modify and delete products.</p>
		
		<a class="btn btn-link btn-lg" href="/admin/genres" role="button">Genres</a></br>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Here you can view,modify and delete genres.</p>
		
		<a class="btn btn-link btn-lg" href="/admin/categories" role="button">Categories</a></br>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Here you can view,modify and delete categories.</p>
	</div>
	
	
	<div class="container">
		<hr class="featurette-divider">
		<a class="btn btn-link btn-lg"  th:href="@{/home}">Back to Home Page</a>
	</div>
	
	<footer class="footer">
      <div class="container">
        <span class="text-muted"> &nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
</body>
</html>