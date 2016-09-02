<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
<title>SiXiang</title>
</head>
<body>
	<div class="sticky-call-us">
       <a>(123)-456-7890&nbsp;&nbsp;&nbsp;<span>Call us<i class="ion-ios-telephone"></i></span><a>      
   </div>
	<div class="sticky-up">
       <a href="#top"><i class='ion-ios-arrow-up'></i></a>
   </div>
    <header class="index" id="top"> <nav>
	<div class="row">
		<img src="assets/resources/img/logo-white.png" alt="logo-white"
			class="logo-white" /> <img src="assets/resources/img/logo-black.png"
			alt="logo-black" class="logo-black" />
		<ul class="main-nav">
			<li><a href="${ contextPath }/shoppingcart">Cart&nbsp;<i
					class="ion-ios-cart" id="nav-cart">&nbsp;&nbsp;0</i>&nbsp;
			</a></li>
			<li><a href="${ contextPath }/menu">Menu</a></li>
			<li><a href="#reach-us">Contact us</a></li>
			<li><a href="#">Rewards</a></li>
		</ul>
	</div>
	</nav>
	<div class="main-text">
		<h1>
			Taste the best<br /> Enjoy the different
		</h1>
		<a href="#" class="btn btn-full js--scroll-to-why-us">Learn more</a> 
		<a href="${ contextPath }/menu" class="btn btn-ghost">Get started</a>
	</div>
	</header>
	<section class="section-why-us js--section-why-us">
	<div class="row">
		<h2>Why choose us</h2>
	</div>
	<div class="row js--wp-1">
		<div class="col span-1-of-4">
			<i class="ion-leaf icon-big"></i>
			<h3>100% organic</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s.</p>
		</div>
		<div class="col span-1-of-4">
			<i class="ion-ribbon-a icon-big"></i>
			<h3>Top chief</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s.</p>
		</div>
		<div class="col span-1-of-4">
			<i class="ion-thumbsup icon-big"></i>
			<h3>Guaranteed authentic</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s.</p>
		</div>
		<div class="col span-1-of-4">
			<i class="ion-umbrella icon-big"></i>
			<h3>Best service</h3>
			<p>Lorem Ipsum is simply dummy text of the printing and
				typesetting industry. Lorem Ipsum has been the industry's standard
				dummy text ever since the 1500s.</p>
		</div>
	</div>
	</section>
	<section class="section-daily-deals">
		<div class="row">
			<h2>Special daily deals</h2>
			<a href="#" class="showmore"><h4>show more...</h4></a>
		</div>
		<div class="row js--wp-2">
			<c:forEach items="${ deals }" var="deal">
				<div class="col span-1-of-4">
					<div class="deal-img">
						<img src="assets/resources/img/${ deal.pic }" alt="${ deal.name }" />
					</div>
	
					<h3>${ deal.name }</h3>
					<h5 class="ordered ordered${ deal.id }">X</h5>
					<div class="price-order-btn">
						<div class="deal-price-ori-price">
							<span class="deal-price">$<fmt:formatNumber type="number" maxFractionDigits="2" value="${ deal.price * deal.discount }"/></span> <span class="ori-price">/$${ deal.price }</span>
						</div>
						<a href="#"
							class="btn btn-full btn-deal add-to-cart" data-id=${ deal.id } data-name="${ deal.name }" data-price="<fmt:formatNumber type='number' maxFractionDigits='2' value='${ deal.price * deal.discount }'/>">
							Order
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>

	<section class="section-chef-rmd">
		<div class="row">
			<h2>Amazing chef's recommendations</h2>
			<a href="#" class="showmore"><h4>show more...</h4></a>
		</div>
		<div class="row  js--wp-3">
		
		<c:forEach items="${ chefRmdDishes }" var="rmd">
			<div class="col span-1-of-4">
				<div class="rmd-img">
					<img src="assets/resources/img/${ rmd.pic }"
						alt="${ rmd.name }" />
				</div>
				
				<div>
					<h3>${ rmd.name }</h3>
					<h5 class="ordered ordered${ rmd.id }">X</h5>
					<div class="price-order-btn">
						<div class="deal-price-ori-price">
							<span class="deal-price">$${ rmd.price }</span>
						</div>						
						<a href="#"
							class="btn btn-full btn-deal add-to-cart" data-id=${ rmd.id } data-name="${ rmd.name }" data-price="${ rmd.price }">
							Order
						</a>
					</div>
				</div>
			</div>	
		</c:forEach>
		</div>
	</section>

	<section class="section-testimonials">
	<div class="row">
		<h2>What our customers say us</h2>
	</div>
	<div class="row">
		<div class="col span-1-of-3">
			<blockquote>
				It is a long established fact that a reader will be distracted by
				the readable content of a page when looking at its layout. The point
				of using Lorem Ipsum is that it has a more-or-less normal
				distribution of letters, as opposed to using 'Content here, content
				here', <cite> <img
					src="assets/resources/img/barack%20obama.jpg"
					alt="Barack Obama" />Barack Obama
				</cite>
			</blockquote>
		</div>
		<div class="col span-1-of-3">
			<blockquote>
				It is a long established fact that a reader will be distracted by
				the readable content of a page when looking at its layout. The point
				of using Lorem Ipsum is that it has a more-or-less normal
				distribution of letters, as opposed to using 'Content here, content
				here', <cite> <img
					src="assets/resources/img/langping.jpg" alt="Langping" />Lang
					Ping
				</cite>
			</blockquote>
		</div>
		<div class="col span-1-of-3">
			<blockquote>
				It is a long established fact that a reader will be distracted by
				the readable content of a page when looking at its layout. The point
				of using Lorem Ipsum is that it has a more-or-less normal
				distribution of letters, as opposed to using 'Content here, content
				here', <cite> <img
					src="assets/resources/img/phelps.jpg" alt="Phelps" />Phelps
				</cite>
			</blockquote>
		</div>
	</div>
	</section>
	<section class="section-reach-us" id="reach-us">
	<div class="row">
		<h2>How to reach us</h2>
	</div>
	<div class="row">
		<div class="col span-1-of-2 js--wp-4-1">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3096.810461573571!2d-77.15362198429723!3d39.088014843289926!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89b7cd742ac74fdb%3A0x6725e95bed97983c!2s410+Hungerford+Dr%2C+Rockville%2C+MD+20850!5e0!3m2!1sen!2sus!4v1472506731930"
				width="550" height="450" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
		<div class="col span-1-of-2 js--wp-4-2">
			<div class="hours">
				<h3>Business hours</h3>
				<div class="hours-left">
					Mon - Thurs: 11:00am - 9:00pm<br /> Fri: 11:00am - 10:00pm

				</div>
				<div class="hours-right">
					Sat: 11:30am - 9:30pm<br /> Sun: 12:00am - 9:30pm
				</div>
			</div>
			<div class="deliver">
				<h3>We deliver for you</h3>
				<p>Minimum order $15 within 5 Mile Radius</p>
			</div>
			<div class="contact-us">
				<h3>Contact us</h3>
				<div>
					<i class="ion-ios-telephone"></i> (301)-456-7890
				</div>
			</div>
			<div class="apps">
				<h3>Downloads our apps</h3>
				<a href="#" class="btn-app apple"> <img
					src="assets/resources/img/apple.jpg" alt="App store button" />
				</a> <a href="#" class="btn-app android"> <img
					src="assets/resources/img/android.jpg" alt="Play store button" />
				</a>
			</div>
		</div>
	</div>
	</section>

	<section class="section-comments">
	<div class="row">
		<h2>We value your opinions</h2>
	</div>
	<form action="#" method="post">
		<div class="row">
			<div class="col span-1-of-3">
				<label>Name</label>
			</div>
			<div class="col span-2-of-3">
				<input type="text" name="name" id="name" placeholder="Your name" />
			</div>
		</div>
		<div class="row">
			<div class="col span-1-of-3">
				<label>Email</label>
			</div>
			<div class="col span-2-of-3">
				<input type="email" name="email" id="email" placeholder="Your email" />
			</div>
		</div>
		<div class="row">
			<div class="col span-1-of-3">
				<label>How do you know us</label>
			</div>
			<div class="col span-2-of-3">
				<select>
					<option value="friends" selected>Friends</option>
					<option value="search">Search engine</option>
					<option value="ads">Advertisements</option>
					<option value="others">Others</option>
				</select>
			</div>
		</div> -->
		<div class="row">
			<div class="col span-1-of-3">
				<label>Comments</label>
			</div>
			<div class="col span-2-of-3">
				<textarea></textarea>
			</div>
		</div>
		<div class="row">
			<div class="col span-1-of-3">
				<label>&nbsp;</label>
			</div>
			<div class="col span-2-of-3">
				<input class="btn btn-full" type="submit" value="Submit" />
			</div>
		</div>
	</form>
	</section>
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