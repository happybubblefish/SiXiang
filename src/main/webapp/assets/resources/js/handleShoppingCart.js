$(function() {
	displayCart();
	$("#nav-cart").html("&nbsp;&nbsp;" + shoppingCart.countCart());
	$("#clear-cart").click(function(event) {
		shoppingCart.clearCart();
		displayCart();

		var total = shoppingCart.countCart();
		$("#nav-cart").html("&nbsp;&nbsp;" + total);
	});

	function displayCart() {
		var cartArray = shoppingCart.listCart();
		var output = "";

		if (shoppingCart.countCart() != 0) {
			output = "<thead><th>Dish name</th><th>Quantity</th><th>Unit price</th><th>Operations</th><th>Subtotal</th></thead><tbody>";

			for ( var i in cartArray) {
				output += "<tr><td>"
						+ cartArray[i].name
						+ "</td>"
						+ "<td>"
						+ cartArray[i].count
						+ "</td>"
						+ "<td>$"
						+ cartArray[i].price
						+ "</td>"
						+ "<td>"
						+ "<a href='#' class='grey-btn plus-item' data-name='"
						+ cartArray[i].name
						+ "'><i class='ion-ios-arrow-up'></i></a>&nbsp;"
						+ "<a href='#' class='grey-btn subtract-item' data-name='"
						+ cartArray[i].name
						+ "'><i class='ion-ios-arrow-down'></i></a>&nbsp;"
						+ "<a href='#' class='grey-btn delete-item' data-name='"
						+ cartArray[i].name
						+ "'><i class='ion-ios-trash-outline'></i></a>"
						+ "</td>" + "<td>$" + cartArray[i].total + "</td></tr>";
			}

			output += "</tbody>";
		}

		$("#show-cart").html(output);
		$("#count-cart").html(shoppingCart.countCart());
		$("#total-cart").html(shoppingCart.totalCart());
	}

	// The reason to use on() instead of using click() is because the contents
	// are dynamically generated. on() actually using bubble up
	// principle to make the table, which is static, to react the click event.
	$("#show-cart").on("click", ".delete-item", function(event) {
		event.preventDefault();
		var name = $(this).attr("data-name");
		shoppingCart.removeItemFromCartAll(name);
		displayCart();

		var total = shoppingCart.countCart();
		$("#nav-cart").html("&nbsp;&nbsp;" + total);
	});

	$("#show-cart").on("click", ".subtract-item", function(event) {
		event.preventDefault();
		var name = $(this).data("name");
		shoppingCart.removeItemFromCart(name);
		displayCart();

		var total = shoppingCart.countCart();
		$("#nav-cart").html("&nbsp;&nbsp;" + total);
	});

	$("#show-cart").on("click", ".plus-item", function(event) {
		event.preventDefault();
		var name = $(this).attr("data-name");
		shoppingCart.addItemToCart(name, 0, 1);
		displayCart();

		var total = shoppingCart.countCart();
		$("#nav-cart").html("&nbsp;&nbsp;" + total);
	});

	$("#show-cart").on("change", ".item-count", function(event) {
		event.preventDefault();
		var name = $(this).attr("data-name");
		var count = Number($(this).val());
		shoppingCart.setCountForItem(name, count);
		displayCart();
	});

	$("#place-order-btn").click(
			function(event) {
				var firstname = $("#firstname").val();
				var lastname = $("#lastname").val();
				var email = $("#email").val();
				var phone = $("#phone").val();
				var address = $("#address").val();

				var cart = shoppingCart.listCart();
				var firstNameErrorMsg = "";
				var lastNameErrorMsg = "";
				var emailErrorMsg = "";
				var phoneErrorMsg = "";
				var addressErrorMsg = "";

				if (cart.length == 0 || firstname == "" || lastname == ""
						|| email == "" || phone == "" || address == "") {
										
					if(firstname == ""){
						firstNameErrorMsg = "First name field is required";
					}else{
						firstNameErrorMsg = "";
					}
					$("#firstnameError").html(firstNameErrorMsg);
					
					if(lastname == ""){
						lastNameErrorMsg = "Last name field is required";
					}else{
						lastNameErrorMsg = "";
					}
					$("#lastnameError").html(lastNameErrorMsg);
					
					if(email == ""){
						emailErrorMsg = "Email field is required";
					}else if(!validateEmail(email)){
						emailErrorMsg = "Please enter valid email format";
					}else{
						emailErrorMsg = "";
					}
					$("#emailError").html(emailErrorMsg);
					
					if(phone == ""){
						phoneErrorMsg = "Phone field is required";
					}else if(!validatePhone(phone)){
						phoneErrorMsg = "Please enter valid phone format";
					}else{
						phoneErrorMsg = "";
					}
					$("#phoneError").html(phoneErrorMsg);
					
					if(address == ""){
						addressErrorMsg = "Address field is required";
					}else{
						addressErrorMsg = "";
					}
					$("#addressError").html(addressErrorMsg);
					
					return;
				}
				
				var customer = {};
				customer.firstName = firstname;
				customer.lastName = lastname;
				customer.email = email;
				customer.phone = phone;
				customer.address = address;

				var u = {
					dishLines : cart,
					customer : customer
				};

				$.ajax({
					url : '/SiXiang/saveshoppingcart',
					data : JSON.stringify(u),
					type : 'POST',
					contentType : "application/json; charset=utf-8",
					dataType : 'json'
				}).success(hello).error(ajaxFailure);
				
				function validateEmail(email) {
				    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				    
				    return re.test(email);
				}
				
				function validatePhone(phone){
					var re = /^[\(]\d{3}[\)][\-]\d{3}[\-]\d{4}$/;
					
					return re.test(phone);
				}

				function hello(data) {
					$("#orderSucceed").html(data.status);

					shoppingCart.clearCart();
					$("#show-cart").html("");
					$("#count-cart").html("0");
					$("#total-cart").html("0.00");
					$("#nav-cart").html("&nbsp;&nbsp;" + "0");

					$("#firstname").val("");
					$("#lastname").val("");
					$("#email").val("");
					$("#phone").val("");
					$("#address").val("");
				}

				function ajaxFailure(xhr, status, exception) {
					alert("Error");
				}

				// location.reload();

				// $("#info").html("<h3 class='order-success'>Thank you for your
				// order. We will send it out when it get ready.</h3>");
			});
}());