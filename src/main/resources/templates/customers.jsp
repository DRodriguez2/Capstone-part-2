<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Welcome Home</title>
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
	<h2 class="display-3">Customers</h2>
	<hr class="featurette-divider">
	
	<br>
	<table id="example" class="table table-striped table-bordered table-hover table-sm">
	<thead class="thead-dark">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Roles</th>
			<th>Orders</th>
		</tr>
	</thead>
	<tbody>
		<tr th:each="u,state : ${user}">
           <td th:text="${state.count}" />
           <td th:text="${u.username}" />
           <td th:text="${u.email}" />
           <td th:text="${u.phoneNumber}" />
           <td th:text="${u.roles}" />
           	<td>
           		<a th:href="@{/admin/viewOrders(user=${u.username})}" class="btn btn-outline-info btn-sm">Orders</a>		
           	</td>
	     </tr>
	</tbody>
	</table>
</div>
<br>
	<div class="container">
		<hr class="featurette-divider">
		<div class="row">
			<div class="col-10">
				<a class="btn btn-link btn-lg"  th:href="@{/home}">Back to Home Page</a>
			</div>
			<div class="col">
				<a class="btn btn-danger btn-lg" href="/logout" role="button">Logout</a></br>
			</div>
		</div>
		
	</div>
	
	<footer class="footer">
      <div class="container">
        <span class="text-muted">&nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
</body>
</html>