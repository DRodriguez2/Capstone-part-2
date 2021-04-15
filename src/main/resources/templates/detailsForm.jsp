<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymleaf.org">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Add/Update Product Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
	<div class = "container">
	 	<div class="row">
	 		<div class="col-md-12">
                <h2 class="display-3">Checkout</h2>
                <div class="row">
					<div class="col">
                		<a href="/music/cart" class="btn btn-primary btn-md">Return to Shopping Cart</a>
						<a class="btn btn-danger" href="/logout" role="button">Logout</a>
					</div>
				</div>
           
                <hr class="featurette-divider">
            </div> 
         
			 <div class="col-md-12 text-center">
                <h4 class="display-4">Order Summary</h4>
            </div>
            <div class="col-md-12">
                <!--INSERT CART OBJECT DATA HERE-->
                 <table class="table table-bordered table-striped table-light table-hover text-center">
                        <thead>
                           <tr>
                               <td>Product</td>
                               <td>Unit Price($)</td>
                               <td>Quantity</td>
                               <td>Price($)</td>
                           </tr> 
                        </thead>
                        <tbody>
							<tr th:each="r : ${results}">
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
                
                <hr class="featurette-divider">
                
            </div> 
            
             <div class="col-md-12 text-center">
                <h4 class="display-4">Payment Info</h4>
            </div>
            
            <div class="col-md-12">
            	<form action="#" th:action="@{/music/processPayment}" method="POST">
			    <input type="hidden" th:value="*{cid}" name="cid">
		   		 <div class="form-group">
					   <label for="cardNumber">Credit Card Number</label>
					   <input type="number" th:value="*{cardNumber}" name="cardNumber" required placeholder="Enter Card Number"
						 		class="form-control">
				   </div>
				   <div class="row">
				     <div class="col-lg-6 pl-3">
					   <div class="form-group">
						   <label for="cvv">CVV</label>
							<input type="number" th:value="*{cvv}" name="cvv" required placeholder="Enter CVV"
							 		class="form-control">
					   </div>
				   </div>
				   	<div class="col-lg-6 pr-0 mob-pl-0">
					   <div class="form-group">
						   <label for="expDate">Expiration Date</label>
						   <input type="date" min="2021-04-13" class="form-control mb-4 col-4" required
						                       placeholder="Exp Date"
						                       th:value="*{expiration}" name="expiration"/>
					   </div>
					   </div>
                  
				   
				   </div>
		 			
		 			<div class="form-group">
		 			 <label for="address">Billing Address</label>
		 			 <textarea th:value="*{address}" name="address" required
					 		class="form-control" rows="3" placeholder="Billing Address"></textarea>
		 			 </div>
		 			 
		 			 <div class="col-md-12 p-0 text-center">
                        <p class="mb-1 pb-2 h5">Accepted Cards: Mastercard, Visa, Discovery</p>
                        
                    </div>
		 			 
		 			 <div class="col-md-12 text-center">
			 			 <button type="submit" class="btn btn-info col-2"
			 			 onclick="if (!(confirm('Are you sure you want to purchase this order?'))) return false;">Complete Payment</button>
			 			 <a href="/music/products" class="btn btn-light col-2">Cancel</a>
		 			 </div>
				</form>
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