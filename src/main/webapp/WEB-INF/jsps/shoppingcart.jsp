<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/vendors/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="assets/vendors/css/grid.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendors/css/ionicons.min.css" />
<link rel="stylesheet" type="text/css" href="assets/vendors/css/animate.css" />
<link rel="stylesheet" type="text/css" href="assets/resources/css/style.css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400"
	rel="stylesheet">
<title>Best Chinese Food</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="sticky-call-us">
       <a>(123)-456-7890&nbsp;&nbsp;&nbsp;<span>Call us<i class="ion-ios-telephone"></i></span><a>      
   </div>
	<header> <nav class="sticky">
	<div class="row">
		<a href="${ contextPath }/index"><img
			src="assets/resources/img/logo-black.png" alt="logo-black"
			class="logo-black" /></a>
		<ul class="main-nav">
			<li><a href="shoppingcart.html">Cart&nbsp;<i
					class="ion-ios-cart" id="nav-cart">&nbsp;&nbsp;0</i>&nbsp;
			</a></li>
			<li><a href="${ contextPath }/menu">Menu</a></li>
			<li><a href="#">Rewards</a></li>
		</ul>
	</div>
	</nav> </header>
	<section class="section-shopping-cart">
	<div class="row">
		<table id="show-cart">
			<!-- <thead>
				<th>Dish name</th>
				<th>Count</th>
				<th>Unit price</th>
				<th>Operations</th>
				<th>Subtotal</th>
			</thead>
			<tbody>
				<tr>
					<td></td>
				</tr>
			</tbody> -->
		</table>
		<div class="cart-info clear-fix">
			<div class="col span-1-of-2">
				<span>Coupon</span>&nbsp;&nbsp;&nbsp; <input type="text"
					name="discount" id="discount" />&nbsp;&nbsp;&nbsp; <a href="#"
					class="redeem-btn" id="redeem">Redeem</a>
			</div>
			<div class="col span-1-of-2">
				<div class="count-cart">
					Total items: <span id="count-cart"></span>
				</div>
				<div class="total-cart">
					Total prices: $<span id="total-cart"></span>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="cart-btns">
			<a href="#" class="cart-btn" id="clear-cart">Clear cart</a> 
			<a href="${ contextPath }/menu" class="cart-btn" id="continue-shopping">Continue shopping</a> 
		</div>
	</div>
	</section>
	
	<section class="section-comments">
        <div class="row">
            <h2>Please enter you information</h2>
        </div>
            <form action="#" method="post">
              <div class="row">
                   <div class="col span-1-of-3">
                       <label><h4>First name</h4></label>
                   </div>
                   <div class="col span-1-of-3">
                       <input type="text" name="firstname" id="firstname" placeholder="First name" required/>
                   </div>
                   <div class="col span-1-of-3">
                   		
                   </div>
               </div>
               
               <div class="row">
                   <div class="col span-1-of-3">
                       <label><h4>Last name</h4></label>
                   </div>
                   <div class="col span-1-of-3">
                       <input type="text" name="lastname" id="lastname" placeholder="Last name" required/>
                   </div>
                   <div class="col span-1-of-3">
                   		
                   </div>
               </div>
               
               <div class="row">
                   <div class="col span-1-of-3">
                       <label><h4>Email</h4></label>
                   </div>
                   <div class="col span-1-of-3">
                       <input type="email" name="email" id="email" placeholder="Your email" required/>
                   </div>
                   <div class="col span-1-of-3">
                   		
                   </div>
               </div>
               
               <div class="row">
                   <div class="col span-1-of-3">
                       <label><h4>Phone</h4></label>
                   </div>
                   <div class="col span-1-of-3">
                       <input type="tel" pattern='[\(]\d{3}[\)][\-]\d{3}[\-]\d{4}'  name="phone" id="phone" placeholder="(123)-456-7890" required/>
                   </div>
                   <div class="col span-1-of-3">
                   		
                   </div>
               </div>
               
               <div class="row">
                   <div class="col span-1-of-3">
                       <label><h4>Address</h4></label>
                   </div>
                   <div class="col span-1-of-3">
                       <input type="text" name="address" id="address" placeholder="Apt., street" required/>
                   </div>
                   <div class="col span-1-of-3">
                   		
                   </div>
               </div>
               
               <div class="row">
                   <div class="col span-1-of-3">
                       <label>&nbsp;</label>
                   </div>
                   <div class="col span-2-of-3 cart-btns">
                       <input id="place-order-btn" type="submit" value="Place order"/>
                       <!-- a href="#" class="cart-btn" id="place-order-btn">Place order</a> -->
                   </div>
               </div>
           </form>
    </section>
    <div id="info">
    	<h3></h3>
    </div>
	<footer>
	<div class="row">
		<div class="col span-1-of-2">
			<ul class="footer-links">
				<li><a href="#">Home</a></li>
				<li><a href="#">About us</a></li>
				<li><a href="#">Career</a></li>
				<li><a href="#">Contact us</a></li>
			</ul>
		</div>
		<div class="col span-1-of-2">
			<ul class="social-links">
				<li><a href="#"><i class="ion-social-facebook"></i></a></li>
				<li><a href="#"><i class="ion-social-twitter"></i></a></li>
				<li><a href="#"><i class="ion-social-googleplus"></i></a></li>
				<li><a href="#"><i class="ion-social-instagram"></i></a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<p>Copyright &copy; 2016 BestChineseFood Inc. All rights are
			reserved.</p>
	</div>
	</footer>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
    <script src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/selectivizr/1.0.3b/selectivizr.min.js"></script>
    <script src="assets/vendors/js/jquery.waypoints.min.js"></script>
    <script src="assets/resources/js/script.js"></script>
    <script src="assets/resources/js/shoppingCart.js"></script>
	<script src="assets/resources/js/handleShoppingCart.js"></script>
</body>
</html>