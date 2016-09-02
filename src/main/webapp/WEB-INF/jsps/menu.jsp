<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="assets/vendors/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="assets/vendors/css/grid.css" />
    <link rel="stylesheet" type="text/css" href="assets/vendors/css/ionicons.min.css" />
    <link rel="stylesheet" type="text/css" href="assets/resources/css/style.css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400" rel="stylesheet">
    <title>Best Chinese Food</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="sticky-call-us">
       <a>(123)-456-7890&nbsp;&nbsp;&nbsp;<span>Call us<i class="ion-ios-telephone"></i></span><a>      
   </div>
	<div class="sticky-up">
       <a href="#top"><i class='ion-ios-arrow-up'></i></a>
   </div>
    <header id="top">
        <nav class="sticky">
            <div class="row"> <a href="${ contextPath }/index"><img src="assets/resources/img/logo-black.png" alt="logo-black" class="logo-black"/></a>
                <ul class="main-nav">
                    <li><a href="${ contextPath }/shoppingcart">Cart&nbsp;<i class="ion-ios-cart" id="nav-cart">&nbsp;&nbsp;0</i>&nbsp;</a></li>
                    <li><a href="${ contextPath }/menu">Menu</a></li>
                    <li><a href="#">Rewards</a></li>
                </ul>
            </div>
        </nav>
    </header>
    
    <section class="section-titles">
        <div class="row">
            <ul>
                <li><a href="#" id="title-beef" class="js--title-beef">Beef</a></li>
                <li><a href="#" id="title-pork" class="js--scroll-to-section-pork">Pork</a></li>
                <li><a href="#" id="title-chicken" class="js--scroll-to-section-chicken">Chicken</a></li>
                <li><a href="#" id="title-seafoods" class="js--scroll-to-section-seafoods">Seafoods</a></li>
            </ul>
        </div>
        
    </section>
    
    <section class="section-beef-menu js--section-beef-menu">
        <div class="row">
            <h2>Beef</h2>
        </div>
        <div class="row">
        	<c:forEach items="${ beefDishes }" var="beefDish">
        		<div class="col span-1-of-4">
                <div class="beef-img">
                	<img src="assets/resources/img/${ beefDish.pic }" alt="${ beefDish.name }" />
                </div>
                
                <h3>${ beefDish.name }</h3>
                <h5 class="ordered ordered${ beefDish.id }">X</h5>
                <div class="price-order-btn"> 
                    <div class="deal-price-ori-price">
                    <c:choose>
                    	<c:when test="${ beefDish.discount < 1}">
                    		<span class="deal-price">$<fmt:formatNumber type='number' maxFractionDigits='2' value='${ beefDish.price * beefDish.discount }'/></span>
                    		<span class="ori-price">/$${ beefDish.price }</span>
                    	</c:when>
                    	<c:otherwise>
                    		<span class="deal-price">$${ beefDish.price }</span>
                    	</c:otherwise>
                    </c:choose>
                    </div>
                    <a href="#"
						class="btn btn-full btn-deal add-to-cart" data-id=${ beefDish.id } data-name="${ beefDish.name }" data-price="${ beefDish.price }">
							Order
					</a>
                </div>
            </div>
        	</c:forEach>
        </div>
    </section>
    
    <section class="section-pork-menu js--section-pork-menu">
        <div class="row">
            <h2>Pork</h2>
        </div>
        <div class="row">
        	<c:forEach items="${ porkDishes }" var="porkDish">
        		<div class="col span-1-of-4">
	                <div class="pork-img"><img src="assets/resources/img/${ porkDish.pic }" alt="${ porkDish.name }" /> </div>
	                <h3>${ porkDish.name }</h3>
	                <h5 class="ordered ordered${ porkDish.id }">X</h5>
	                <div class="price-order-btn"> 
	                    <div class="deal-price-ori-price">
	                    	<c:choose>
                    			<c:when test="${ porkDish.discount < 1}">
                    				<span class="deal-price">$<fmt:formatNumber type='number' maxFractionDigits='2' value='${ porkDish.price * porkDish.discount }'/></span>
                    				<span class="ori-price">/$${ porkDish.price }</span>
                    			</c:when>
                    			<c:otherwise>
                    				<span class="deal-price">$${ porkDish.price }</span>
                    			</c:otherwise>
                    		</c:choose>
	                    </div>
	                    <a href="#"
							class="btn btn-full btn-deal add-to-cart" data-id=${ porkDish.id } data-name="${ porkDish.name }" data-price="${ porkDish.price }">
							Order
						</a>
	                </div>
            	</div>
        	</c:forEach>
        </div>
    </section>
    
    <section class="section-chicken-menu js--section-chicken-menu">
        <div class="row">
            <h2>Chicken</h2>
        </div>
        <div class="row">
        	<c:forEach items="${ chickenDishes }" var="chickenDish">
        		<div class="col span-1-of-4">
	                <div class="chicken-img"><img src="assets/resources/img/${ chickenDish.pic }" alt="${ chickenDish.name }" /> </div>
	                <h3>${ chickenDish.name }"</h3>
	                <h5 class="ordered ordered${ chickenDish.id }">X</h5>
	                <div class="price-order-btn"> 
	                    <div class="deal-price-ori-price">
	                    	<c:choose>
                    			<c:when test="${ chickenDish.discount < 1}">
                    				<span class="deal-price">$<fmt:formatNumber type='number' maxFractionDigits='2' value='${ chickenDish.price * chickenDish.discount }'/></span>
                    				<span class="ori-price">/$${ chickenDish.price }</span>
                    			</c:when>
                    			<c:otherwise>
                    				<span class="deal-price">$${ chickenDish.price }</span>
                    			</c:otherwise>
                    		</c:choose>
	                    </div>
	                    <a href="#"
							class="btn btn-full btn-deal add-to-cart" data-id=${ chickenDish.id } data-name="${ chickenDish.name }" data-price="${ chickenDish.price }">
							Order
						</a>
	                </div>
            	</div>
        	</c:forEach>
        </div>
    </section>
    <section class="section-seafoods-menu js--section-seafoods-menu">
        <div class="row">
            <h2>Seafoods</h2>
        </div>
        <div class="row">
        	<c:forEach items="${ seafoodsDishes }" var="seafoodsDish">
        		<div class="col span-1-of-4">
                <div class="seafoods-img"><img src="assets/resources/img/${ seafoodsDish.pic }" alt="${ seafoodsDish.name }" /> </div>
                <h3>${ seafoodsDish.name }</h3>
                <h5 class="ordered ordered${ seafoodsDish.id }">X</h5>
                <div class="price-order-btn"> 
                    <div class="deal-price-ori-price">
                    	<c:choose>
                    		<c:when test="${ seafoodsDish.discount < 1}">
                    			<span class="deal-price">$<fmt:formatNumber type='number' maxFractionDigits='2' value='${ seafoodsDish.price * seafoodsDish.discount }'/></span>
                    			<span class="ori-price">/$${ seafoodsDish.price }</span>
                    		</c:when>
                    		<c:otherwise>
                    			<span class="deal-price">$${ seafoodsDish.price }</span>
                    		</c:otherwise>
                    	</c:choose>
                    </div>
                    <a href="#"
						class="btn btn-full btn-deal add-to-cart" data-id=${ seafoodsDish.id } data-name="${ seafoodsDish.name }" data-price="${ seafoodsDish.price }">
							Order
					</a>
                </div>
            </div>
        	</c:forEach>
        </div>
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
             <p>
                Copyright &copy; 2016 BestChineseFood Inc. All rights are reserved.
             </p>
         </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/respond/1.4.2/respond.min.js"></script>
    <script src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/selectivizr/1.0.3b/selectivizr.min.js"></script>
    <script src="assets/vendors/js/jquery.waypoints.min.js"></script>
    <script src="assets/resources/js/script.js"></script>
    <script src="assets/resources/js/shoppingCart.js"></script>
    
    <script src="assets/resources/js/addToCart.js">
		$("#nav-cart").html("&nbsp;&nbsp;" + shoppingCart.countCart());

		$(".add-to-cart").click(function(event) {
			event.preventDefault();
			var name = $(this).attr("data-name");
			var price = Number($(this).attr("data-price"));
			var id = $(this).attr("data-id");
			shoppingCart.addItemToCart(name, price, 1);

			var itemList = shoppingCart.listCart();

			var count = 0;
			for ( var i in itemList) {
				if (itemList[i].name == name) {
					count = itemList[i].count;
				}
			}

			var output = count + " added to cart";
			var cc = ".ordered" + id;
			$(cc).css("opacity", "1");
			$(cc).html(output);

			var total = shoppingCart.countCart();
			$("#nav-cart").html("&nbsp;&nbsp;" + total);
		});
	</script>
</body>
</html>