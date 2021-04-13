<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart Items</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <style>
       
    </style>
</head>
<body>
    <br/>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2 class="display-4">Cart Items</h2>
                <hr class="featurette-divider">
            </div> 
            
			<hr class="featurette-divider">
            
            <div class="col-md-12">
                <table class="table table-bordered table-striped table-light table-hover text-center">
                        <thead>
                           <tr>
                               <td>Product</td>
                               <td>Unit Price($)</td>
                               <td>Quantity</td>
                               <td>Price($)</td>
                              
                           </tr> 
                           <!--INSERT DATA FOR PRODUCTS HERE-->
                        </thead>
                        
                        <tbody>
							<tr th:each="r : ${res}">
					           <td th:text="${r.title}" />
					           <td th:text="${r.price}"/>
					       	   <td th:text="${r.quantity}"/>
					       	   <td th:text="${r.totalPrice}"/>
						     </tr>
					</tbody>
                </table>
                <div class="row">
	                <div class="col-9"></div>
	                <div class="col">
	                 	<h4  th:inline="text">Grand Total: $[[${total}]]</h4>
	            	</div>
        		</div>
                
            </div>
            
        </div>
          <hr class="featurette-divider">
    </div>
    <div class="row">
		<div class="col-5">
		</div>
		<div class="col">
			<a class="btn btn-primary" href="/music/orders" role="button">Back</a>
			<a class="btn btn-danger" href="/logout" role="button">Logout</a>
			<a class="btn btn-secondary" href="/home" role="button">Home</a>
		</div>
	</div>
	
	<footer class="footer">
      <div class="container">
      	<hr class="featurette-divider">
        <span class="text-muted"> &nbsp;&nbsp;&copy; 2021 Copyright: Team X </span>
      </div>
    </footer>
</body>
</html>