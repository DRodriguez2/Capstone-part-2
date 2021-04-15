<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>About Product</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="display-3">Product Detail</h1>
		<p>Here is the detail information of the product!</p>
		<hr class="featurette-divider">
		
		<h4 class="display-4" th:inline="text">[[${res.title}]]</h4>
		<h3  th:inline="text">Type: [[${res.type}]]</h3>
		<h3  th:inline="text">Genre: [[${res.category.genre.name}]]</h3>
		<h3  th:inline="text">Category: [[${res.category.name}]]</h3>
		<h3  th:inline="text">Artist: [[${res.artist}]]</h3>
		<h3  th:inline="text">Price: $[[${res.price}]]</h3>
		<h3  th:inline="text">Description: [[${res.description}]]</h3>
	</div>
	
	
	<div class="container">
		<hr class="featurette-divider">
		<a class="btn btn-link btn-lg"  th:href="@{/admin/products1}">Go Back</a>
	</div>
	
	<footer class="footer">
      <div class="container">
        <span class="text-muted"> &nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
</body>
</html>