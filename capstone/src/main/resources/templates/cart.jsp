<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Cart</title>
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
                <h2 class="display-4">My Shopping Cart</h2>
                <hr class="featurette-divider">
            </div> 
            
            <div class="col-md-10">
			</div>
				
			<div class="col-md-2">
				<a class="btn btn-danger btn-md" th:href="@{/music/deleteCartItems}" 
				role="button" 
				onclick="if (!(confirm('Are you sure you want to clear this cart?'))) return false;">Clear Cart</a></br>
			</div>
			<br>
			<br>
			<hr class="featurette-divider">
            
            <div class="col-md-12">
                <table class="table table-bordered table-striped table-light table-hover text-center">
                        <thead>
                           <tr>
                               <td>Product</td>
                               <td>Unit Price($)</td>
                               <td>Quantity</td>
                               <td>Price($)</td>
                               <td>Action</td>
                           </tr> 
                           <!--INSERT DATA FOR PRODUCTS HERE-->
                        </thead>
                        
                        <tbody>
							<tr th:each="r : ${results}">
					           <td th:text="${r.title}" />
					           <td th:text="${r.price}"/>
					       	   <td th:text="${r.quantity}"/>
					       	   <td th:text="${r.totalPrice}"/>
					           <td>
					           	<a th:href="@{/music/deleteCartItem(cartId=${r.cid}, productId=${r.pid})}" class="btn btn-danger btn-sm"
					           	onclick="if (!(confirm('Are you sure you want to remove this product from the cart?'))) return false;">Remove</a>		
			           		  </td>
						     </tr>
					</tbody>
                </table>
                <div class="row">
                <div class="col-8"></div>
                <div class="col">
                 	<h4  th:inline="text">Grand Total: $[[${total}]]</h4>
            	</div>
        </div>
                
            </div>
            <div class="col-md-12">
                <div class="pull-right">
                    <a href="/music/products" class="btn btn-light btn-md">Continue Shopping</a>
                    <a href="/music/paymentInfo" class="btn btn-success btn-md">Checkout</a>
                </div>
                 <hr class="featurette-divider">
            </div>
        </div>
    </div>
    <div class="row">
		<div class="col-5">
		</div>
		<div class="col">
			<a class="btn btn-primary" href="/music/products" role="button">Back</a>
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