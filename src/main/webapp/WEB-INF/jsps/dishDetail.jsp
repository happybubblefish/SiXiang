<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
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
<body>
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
	<div class="container">
		<div class="row">
			
		</div>
	</div>
		
	</body>