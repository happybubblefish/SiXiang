
$(function(){
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
}());