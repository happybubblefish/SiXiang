<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="assets/vendors/css/normalize.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendors/css/grid.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendors/css/ionicons.min.css" />
<link rel="stylesheet" type="text/css"
	href="assets/vendors/css/animate.css" />
<link rel="stylesheet" type="text/css"
	href="assets/resources/css/style.css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<header>
		<nav class="sticky">
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

					<sec:authorize access="!hasAnyRole('ROLE_USER')">
						<li><a href="${ contextPath }/login">Login</a></li>
						<li><a href="${ contextPath }/registration">Registration</a></li>
					</sec:authorize>

					<sec:authorize access="hasAnyRole('ROLE_USER')">
						<li><a href="${ contextPath }/logout">Logout</a></li>
					</sec:authorize>
				</ul>
			</div>
		</nav>
	</header>

	<section class="section-login">
		<div class="row">
			<h2>Please register</h2>
			<form:form commandName="userCredentials"
				action="${ contextPath }/registration" method="post">
				<div class="row">
					<div class="col span-1-of-3">
						<label for="username"><h4>Username</h4></label>
					</div>
					<div class="col span-1-of-3">
						<form:input type="text" path="username" placeholder="Your email" />
					</div>
					<div id="registration-username" class="col span-1-of-3">
						<form:errors path="username" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<div class="col span-1-of-3">
						<label for="password"><h4>Password</h4></label>
					</div>
					<div class="col span-1-of-3">
						<form:input type="password" path="password" placeholder="Password" /><br/>
						<span class="password-requirement">Password includes 8 - 10 characters</span><br/>
						<span class="password-requirement">Must have at least 1 lowercase, 1 uppercase and 1 special character</span>
					</div>
					<div id="registration-password" class="col span-1-of-3">
						<form:errors path="password" cssClass="error" />
					</div>
				</div>
				<div class="row">
					<div class="col span-1-of-3">
						<label for="passwordConfirm"><h4>Re-enter password</h4></label>
					</div>
					<div class="col span-1-of-3">
						<form:input type="password" path="passwordConfirm"
							placeholder="Confirm Password" />
					</div>
					<div id="registration-confirmpassword" class="col span-1-of-3">
						<form:errors path="passwordConfirm" cssClass="error" />
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="row">
					<div class="col span-1-of-3"></div>
					<div class="col span-1-of-3">
						<input type="submit" class="btn btn-full btn-registration"
							value="Submit" /> <a class="btn btn-ghost btn-cancel"
							href="${ contextPath }/index">Cancel</a>
					</div>
				</div>
			</form:form>
		</div>
	</section>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
<script src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/selectivizr/1.0.3b/selectivizr.min.js"></script>
<script src="assets/vendors/js/jquery.waypoints.min.js"></script>
<script src="assets/resources/js/script.js"></script>
<script src="assets/resources/js/shoppingCart.js"></script>
<script src="assets/resources/js/addToCart.js"></script>
</html>


