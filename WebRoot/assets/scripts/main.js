jQuery(document).ready(function($) {

    'use-strict';

    function RYsmoothScroll(){
        if(navigator.appVersion.indexOf("Mac")==-1){
            $('body').append("<script src='vendors/smooth-scroll/SmoothScroll.js'></script>");
        }
    }
    RYsmoothScroll();


    function RYratingStar(){
        $('.ry-rating').each(function() {
            var point = $(this).attr('data-rating');
            if (point == 5) {
                $(this).children().addClass('ry-rated');
            }else{
                $(this).children().eq(point).prevAll().addClass('ry-rated');
            }
        });
    }
    RYratingStar();


    //useful var
    var $window = $(window);
    var gsnavfixH = $('#ry-navfix').outerHeight() || 0;

    function RYzoomImage() {
        $(".ry-zoom-image").elevateZoom({
            imageCrossfade: true,
            responsive: true,
            easing : true,
            zoomType    : "inner",
            cursor: "crosshair",
            loadingIcon: 'http://www.elevateweb.co.uk/spinner.gif'
        });
    }


    RYzoomImage();

    function RYproductGalery () {
            var zoomObject = $('.ry-product-image img').data('elevateZoom');
            var $thumbImage = $('.ry-product-image-list img');

            $thumbImage.on('click', function(event) {
                var thumbSRC = $(this).attr('src');
                var zoomSRC = $(this).attr('data-zoom-image');
                if (zoomSRC) {
                    zoomObject.swaptheimage(thumbSRC, zoomSRC);
                }
                else{
                    $(this).parent().next().children('img').attr('src' , thumbSRC);
                }
                event.preventDefault();
            });
    }
    RYproductGalery();


    /**
     * Config MainNav
     */

    function scaleNav() {
        $(window).on('ready , scroll', function() {
            if ($(window).scrollTop() > 30) {
                $('.ry-main-nav').addClass('ry-scale');
            } else {
                $('.ry-main-nav').removeClass('ry-scale');
            }
        });
    }
    scaleNav();

    function RYmainNav() {
        $('.ry-nav-hamburger').on('click', function(event) {
            $('.ry-nav-menu ').toggleClass('ry-nav-appeared');
            event.preventDefault();
        });

        $('.ry-menu-dropdown >a').on('click', function(event){
            if ($(window).width() < 1200) {
                $(this).next().toggleClass('ry-dropdown-active');
            }
            event.preventDefault();
        });
    }

    RYmainNav();

    function RYproductItemContent () {
        $(window).on('ready , resize', function() {
            var PIW = $('.ry-product-group-button').width();
            if (PIW < 381) {
                $('.ry-product-group-button').addClass('ry-pi-small');
            }
            else{
                $('.ry-product-group-button').removeClass('ry-pi-small');
            }
            event.preventDefault();
        });
    }
    RYproductItemContent();


    /**
     * Home slider
     */


    function RYslider () {
        $('.ry-home-slider').flexslider({
            animationSpeed: 900,
            easing:"easeInOutSine",
            start: function(){
                RYSliderCaptionShow();
            },
            before: function(){
                RYcaptionSliderCaptionHide();
            },
            after: function(){
                RYSliderCaptionShow();
            }
        });
    }
    RYslider();


    /**
     * Home Slider min-height 100% window
     */
    function fullHeightSlider() {
        $(window).on('ready , resize', function() {
            $('.ry-home-slider .ry-caption-wrapper').height($(window).height());
        });
    }
    fullHeightSlider();

    /**
     * Call back to hide Home slider caption
     */
    function RYcaptionSliderCaptionHide() {
        var $caption = $('.ry-home-slider-item .ry-caption-wrapper').children().find('.ry-caption');
        if(Modernizr.cssanimations){
            $caption.css('animation', 'fadeOutDown 0s forwards');
        }
        else{
            $caption.css('opacity', '0');
        }
    }


    /**
     * Call back to show slider caption
     */

    function RYSliderCaptionShow() {
        var $thisCaption = $('.flex-active-slide.ry-home-slider-item .ry-caption-wrapper').children().find('.ry-caption');
        if(Modernizr.cssanimations){
            $thisCaption.each(function() {
                var delayTime = $(this).index() * 900 + 600;
                $(this).css('animation', 'fadeInUp 400ms ' + delayTime + 'ms forwards');
            });
        }
        else{
            $thisCaption
                .animate({opacity: 1 }, 500);
        }
    }

    /**
     * Jquery Input
     */
    function RYinput() {
        $('input, textarea').placeholder();
    }
    RYinput();

    /**
     * HTML5shiv
     */
    window.html5 = {
        'shivCSS': true
    };

});