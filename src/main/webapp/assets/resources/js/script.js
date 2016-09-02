$(function () {
    /* Sticky navigation */
    $(".js--section-why-us").waypoint(function (direction) {
        if (direction == "down") {
            $("nav").addClass("sticky");
        }
        else {
            $("nav").removeClass("sticky");
        }
    }, {
        offset: "130px"
    });
    
    
    /* Scroll on buttons */
    $(".js--scroll-to-why-us").click(function () {
        $("html, body").animate({
            scrollTop: $(".js--section-why-us").offset().top - 100
        }, 1000);
    });
    $(".js--scroll-to-section-pork").click(function () {
        $("html, body").animate({
            scrollTop: $(".js--section-pork-menu").offset().top - 100
        }, 1000);
    });
    
    $(".js--scroll-to-section-chicken").click(function () {
        $("html, body").animate({
            scrollTop: $(".js--section-chicken-menu").offset().top - 20
        }, 500);
    });
    
    $(".js--scroll-to-section-seafoods").click(function () {
        $("html, body").animate({
            scrollTop: $(".js--section-seafoods-menu").offset().top - 100
        }, 500);
    });
    
    /* Navigation scroll */
    $(function () {
        $('a[href*="#"]:not([href="#"])').click(function () {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html, body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
    
    
    /* CSS animation */
    $(".js--wp-1").waypoint(function (direction) {
        $(".js--wp-1").addClass("animated fadeIn");
    }, {
        offset: "50%"
    });
    
    $(".js--wp-2").waypoint(function (direction) {
        $(".js--wp-2").addClass("animated bounceInDown");
    }, {
        offset: "50%"
    });
    
    $(".js--wp-3").waypoint(function (direction) {
        $(".js--wp-3").addClass("animated zoomIn");
    }, {
        offset: "50%"
    });
    
    $(".js--wp-4-1").waypoint(function (direction) {
        $(".js--wp-4-1").addClass("animated slideInLeft");
    }, {
        offset: "50%"
    });
    
    $(".js--wp-4-2").waypoint(function (direction) {
        $(".js--wp-4-2").addClass("animated slideInRight");
    }, {
        offset: "50%"
    });
    
    
    /* Top animation*/
    $(".js--wp-2").waypoint(function(direction){
        if(direction == "down"){
            $(".sticky-up").css("opacity", "0.8");
        }else{
            $(".sticky-up").css("opacity", "0");
        }
        
    }, {
        offset: "50%"
    });
    
    /* Top animation*/
    $(".js--section-chicken-menu").waypoint(function(direction){
        if(direction == "down"){
            $(".sticky-up").css("opacity", "0.8");
        }else{
            $(".sticky-up").css("opacity", "0");
        }
        
    }, {
        offset: "50%"
    });
});