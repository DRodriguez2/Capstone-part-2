<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Add Genre Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<h2> Add/Update Genre </h2>
		<br>
		<form action="#" th:action="@{/admin/saveGenre}" th:object="${genre}" method="POST">
			<input type="hidden" th:field="*{id}">
		
		    <label for="genreName">Genre</label>
		
			<input type="text" th:field="*{name}" required
			 		class="form-control mb-4 col-4" placeholder="Genre Name">
 			 
 			 <button type="submit" class="btn btn-info col-2">Save</button>
		</form>
	</div>
	
	<br>
	<div class="container">
		<a th:href="@{/home}">Back to Home Page</a>
	</div>
	
	<footer class="footer">
      <div class="container">
        <span class="text-muted"> &nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
	
</body>
</html>