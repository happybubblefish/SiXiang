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
	<div class="row">
		<div class="rewards">
			<p>
				Your rewards:&nbsp;&nbsp;&nbsp;
				<fmt:formatNumber type='number' maxFractionDigits='2'
					value='${ rewards }' />
				points.
			</p>
		</div>
	</div>
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
</body>
</html>
