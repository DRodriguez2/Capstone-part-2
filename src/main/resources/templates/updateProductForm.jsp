<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Update Product Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
		<h2> Update Track/Album</h2>
		<br>
		<form action="#" th:action="@{/admin/updateProduct}" method="POST"  th:object="${res}">
			<input type="hidden" th:field="*{type}" name="type">
			<input type="hidden" th:field="*{pid}" name="pid">
			<input type="hidden" th:field="*{tid}" name="pid">
			<input type="hidden" th:field="*{aid}" name="pid">

			<label for="title">Title</label>
			<input type="text" th:field="*{title}" name="title" required
			 		class="form-control mb-4 col-4" placeholder="Name">
			 
			<label for="artist">Artist</label>
			<input type="text" th:field="*{artist}" name="artist" required
			 		class="form-control mb-4 col-4" placeholder="Artist Name">
			 		
			<label for="price">Price</label>
			<input type="number" th:field="*{price}" name="price" required step=".01"
			 		class="form-control mb-4 col-4" placeholder="Name">
		   
		    <label for="genreName">Genre</label>
			 <select class="form-control mb-3 col-4"  th:field="*{genre}" name="genre">
			    <option value="0">--Select Genre--</option>
			    <option th:each="g : ${genres}" th:value="${g.id}" th:text="${g.name}"></option>
 			 </select>
 			 
		   
		 	<label for="categoryName">Category</label>
			 <select class="form-control mb-3 col-4"  th:field="*{category}" name="category">
			    <option value="0">--Select Category--</option>
			    <option th:each="c : ${categories}" th:value="${c.id}" th:text="${c.name}"></option>
 			 </select>
 			 
 			
 			 <label for="des.">Description</label>
 			 <textarea  th:field="*{description}" name="description" required
			 		class="form-control mb-4 col-4" rows="3" placeholder="Description"></textarea>
 	
 			 
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