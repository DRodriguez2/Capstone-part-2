<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Products</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css"  crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/1.10.24/features/searchHighlight/dataTables.searchHighlight.css" crossorigin="anonymous">
	<script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"  crossorigin="anonymous"> </script>
	<script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
	<script src="https://cdn.datatables.net/plug-ins/1.10.24/features/searchHighlight/dataTables.searchHighlight.min.js" crossorigin="anonymous"></script>
	<script src="https://bartaz.github.io/sandbox.js/jquery.highlight.js"></script>
	<script>
		$.fn.dataTable.ext.search.push(
		    function( settings, data, dataIndex ) {
		        var min = parseFloat( $('#min').val() );
		        var max = parseFloat( $('#max').val());
		        var age = parseFloat( data[6] ) || 0; // use data for the age column
		 
		        if ( ( isNaN( min ) && isNaN( max ) ) ||
		             ( isNaN( min ) && age <= max ) ||
		             ( min <= age   && isNaN( max ) ) ||
		             ( min <= age   && age <= max ) )
		        {
		            return true;
		        }
		        return false;
		    }
		);
		
		$(document).ready(function() {
			
		   var table = $('#example').DataTable({
		    	 "lengthMenu": [ [5, 10, 25, 50, -1], [5, 10, 25, 50, "All"] ],
		    	  searchHighlight: true,
		    	 
		    });
		   // Event listener to the two range filtering inputs to redraw on input
		    $('#min, #max').keyup( function() {
		        table.draw();
		    } );
		    myTable.on( 'draw', function () {
	            var body = $( myTable.table().body() );
	            body.unhighlight();
	            body.highlight( myTable.search() );  
	        } );
		   
		});
	</script>
	
	
</head>
<body>
	<div class="container">
		<h1 class="display-3">Products Page</h1>
		<p>This is the products page!</p>
		<hr class="featurette-divider">
		<div class="row">
			<div class="col-10">
				<div class="dropdown">
				  <button class="btn btn-primary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    Add Product
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    <a class="dropdown-item" href="/admin/addTrack">Track</a>
				    <a class="dropdown-item" href="/admin/addAlbum">Album</a>
				  </div>
				</div>
			</div>
			<div class="col">
				<a class="btn btn-danger btn-lg" href="/logout" role="button">Logout</a></br>
			</div>
		</div>
		<hr class="featurette-divider">
		
    	<div class="row">
    	 <div class="col col-lg-3"></div>
    	  <div class="col col-lg-3"></div>
		  <div class="col col-lg-3">
		  	 <table border="0" cellspacing="5" cellpadding="5">
	        	<tbody>
	         		<tr>
	         			
			            <td><b>Minimum Price:</b></td>
			            
			            <td><input type="number" id="min" name="min" step="0.01"></td>
			            <td><b>Maximum Price:</b></td>
			            <td ><input type="number" id="max" name="max" step="0.01"></td>
	        		</tr>
    			</tbody>
    	</table>
		  </div>
		</div>
		<table id="example"  class="table table-bordered table-striped table-light table-hover">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Artist</th>
					<th>Genre</th>
					<th>Category</th>
					<th>Type</th>
					<th>Price($)</th>
					<th style="display:none;">Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="r,state : ${results}">
		           <td th:text="${state.count}" />
		           <td th:text="${r.title}" />
		           <td th:text="${r.artist}"/>
		           <td th:text="${r.category.genre.name}"/>
		           <td th:text="${r.category.name}"/>
		           <td th:text="${r.type}"/>
		           <td th:text="${r.price}"/>
		           <td style="display:none;" th:text="${r.description}"/>
		           <td>
		           	<a th:href="@{/admin/aboutProduct(productId=${r.pid})}" class="btn btn-info btn-sm">Info</a>
		           	<a th:href="@{/admin/updateProduct1(productId=${r.pid})}" class="btn btn-warning btn-sm">Update</a>
		           	<a th:href="@{/admin/deleteProduct(productId=${r.pid})}" class="btn btn-danger btn-sm"
		           	onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false;">Delete</a>		
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