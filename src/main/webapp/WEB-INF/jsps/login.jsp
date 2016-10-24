<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body onload='document.f.j_username.focus();'>
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
			<li><a href="${ contextPath }/rewards">Rewards</a></li>
			
			<li><a href="${ contextPath }/comments?dishId=2">Comments</a></li>
			
			<sec:authorize access="!hasAnyRole('ROLE_USER')">
				<li><a href="${ contextPath }/login">Login</a></li>
				<li><a href="${ contextPath }/registration">Registration</a></li>
			</sec:authorize>
			
			<sec:authorize access="hasAnyRole('ROLE_USER')">
				<li><a href="${ contextPath }/logout">Logout</a></li>
			</sec:authorize>
		</ul>
	</div>
	</nav> </header>
	
	
	<%-- <body onload='document.f.j_username.focus();'>
	<div class="login-page">
		<div class="form">
		<h3 class="loginTitle">GoFitness Login Page</h3>
			<form class="login-form" action="${contextPath}/login.html" name="f"
				method="post">
				<input type="text" id="username" name="username" placeholder="Username" />
				<input type="password" id="password" name="password" placeholder="Password" /> 
				<span class="clearfix"></span>
				<span class="error">${ error }</span> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button type="submit">login</button>
				<p class="message"> Not registered? <a href="${ contextPath }/registration.html">Create an account</a>
				</p>
			</form>
		</div>
	</div>
</body> --%>

	<section class="section-login">
		<div class="row">
			<h2>Please login</h2>
			<form action="${ contextPath }/login" name="f" method="post">
				<div class="row">
					<div class="col span-1-of-3">
						<label for="username"><h4>Username</h4></label>
					</div>
					<div class="col span-1-of-3">
						<input type="text" id="username" name="username" placeholder="Username"/>
					</div>
					<div id="login-username" class="col span-1-of-3">
					
					</div>
				</div>
				<div class="row">
					<div class="col span-1-of-3">
						<label for="password"><h4>Password</h4></label>
					</div>
					<div class="col span-1-of-3">
						<input type="text" id="password" name="password" placeholder="Password"/>
					</div>
					<div id="login-password" class="col span-1-of-3">
					
					</div>
				</div>
				<div class="row">
					<div class="col span-1-of-3">
						
					</div>
					<div class="col span-1-of-3">
						<input type="submit" class="btn btn-full btn-login" value="Login"/>
						<a class="btn btn-ghost btn-cancel" href="${ contextPath }/index">Cancel</a>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<p class="message"> Not registered? <a href="${ contextPath }/registration.html">Create an account</a>
					</div>
				</div>
			</form>
		</div>
	</section>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
	<script src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://cdn.jsdelivr.net/selectivizr/1.0.3b/selectivizr.min.js"></script>
	<script src="assets/vendors/js/jquery.waypoints.min.js"></script>
	<script src="assets/resources/js/script.js"></script>
	<script src="assets/resources/js/shoppingCart.js"></script>
	<script src="assets/resources/js/addToCart.js"></script>
</body>
</html>


