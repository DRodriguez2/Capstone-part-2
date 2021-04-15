<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Categories</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css"  crossorigin="anonymous">
	<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"  crossorigin="anonymous"> </script>
	<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
		    $('#example').dataTable({
		    	 "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ]
		    });
		
		});
	</script>
 
</head>
<body>
	<div class="container">
		<h1 class="display-3">Categories</h1>
		<p>This is the categories page!</p>
		<hr class="featurette-divider">
		
		<div class="row">
			<div class="col-10">
					<a class="btn btn-primary btn-lg" href="/admin/categoryForm" role="button">Add Category</a></br>
					
			</div>
			<div class="col">
				<a class="btn btn-danger btn-lg" href="/logout" role="button">Logout</a></br>
			</div>
		</div>
		<hr class="featurette-divider">
		<table id="example" class="table table-bordered table-striped table-light table-hover">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Genre</th>
					<th>Category</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="c,state : ${categories}">
		           <td th:text="${state.count}" />
		           <td th:text="${c.genre.name}" />
		           <td th:text="${c.name}" />
		           <td>
		           	<a th:href="@{/admin/updateCategory(categoryId=${c.id})}" class="btn btn-info btn-sm">Update</a>
		           	<a th:href="@{/admin/deleteCategory(categoryId=${c.id})}" class="btn btn-danger btn-sm"
		           	onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false;">Delete</a>		
           		  </td>
			     </tr>
			</tbody>
		</table>		
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