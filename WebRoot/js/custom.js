(function($) {
"use strict";

/* ==============================================
ANIMATION -->
=============================================== */

    new WOW({
	    boxClass:     'wow',      // default
	    animateClass: 'animated', // default
	    offset:       0,          // default
	    mobile:       true,       // default
	    live:         true        // default
    }).init();
  
/* ==============================================
CAROUSEL -->
=============================================== */

   	$('#owl-blog').owlCarousel({
		loop:true,
		margin:30,
		nav:true,
		dots:false,
		responsive:{
		0:{
		items:1
		},
		600:{
		items:2
		},
		1000:{
		items:2
		}
	}
	})

   	$('#owl-client').owlCarousel({
		loop:true,
		margin:0,
		nav:false,
	    loop:true,
	    autoplay:true,
	    autoplayTimeout:2500,
	    autoplayHoverPause:true,
		dots:false,
		responsive:{
		0:{
		items:1
		},
		600:{
		items:3
		},
		1000:{
		items:5
		}
	}
	})

   	$('#blog-carousel').owlCarousel({
		loop:true,
		margin:0,
		nav:true,
	    loop:true,
	    autoplay:true,
	    autoplayTimeout:2500,
	    autoplayHoverPause:true,
		dots:false,
		responsive:{
		0:{
		items:1
		},
		600:{
		items:1
		},
		1000:{
		items:1
		}
	}
	})

/* ==============================================
TESTIMONIAL -->
=============================================== */

	$(document).ready(function() {
		var image_array = new Array();
			image_array = [
				{image: 'upload/1.jpg', link_url: 'upload/1big.jpg', link_rel: 'prettyPhoto',
					upper_text_label_show: 0, upper_text_label: '', upper_text_label_style: '', lower_text_label_show: 1, lower_text_label: 'Amanda', lower_text_label_style: 'text-shadow: 1px 1px 1px #cccccc;'},
				{image: 'upload/2.jpg', link_url: 'upload/2big.jpg', link_rel: 'prettyPhoto',
					upper_text_label_show: 0, upper_text_label: '', upper_text_label_style: '', lower_text_label_show: 1, lower_text_label: 'Ben', lower_text_label_style: 'text-shadow: 1px 1px 1px #cccccc;'},
				{image: 'upload/3.jpg', link_url: 'upload/3big.jpg', link_rel: 'prettyPhoto',
					upper_text_label_show: 0, upper_text_label: '', upper_text_label_style: '', lower_text_label_show: 1, lower_text_label: 'Giselle', lower_text_label_style: 'text-shadow: 1px 1px 1px #cccccc;'}
			];
			$('#slider1').content_slider({		// bind plugin to div id="slider1"
				map : image_array,				// pointer to the image map
				max_shown_items: 3,				// number of visible circles
				hv_switch: 0,					// 0 = horizontal slider, 1 = vertical
				active_item: 0,					// layer that will be shown at start, 0=first, 1=second...
				big_pic_width:134,
				big_pic_height:134,
				border_color:'#ffffff',
				big_border:1,
				hide_prettyPhoto:1,
				small_border:1,
				small_pic_width:74,
				small_pic_height:74,
				wrapper_text_max_height:300,	// height of widget, displayed in pixels
				middle_click: 1,				// when main circle is clicked: 1 = slider will go to the previous layer/circle, 2 = to the next
				under_600_max_height: 1200,		// if resolution is below 600 px, set max height of content
				border_radius:	-1,				// -1 = circle, 0 and other = radius
				automatic_height_resize: 1,
				border_on_off: 1,
				allow_shadow: 0
			});

/* ==============================================
SLIDER -->
=============================================== */

		jQuery('.tp-banner').show().revolution(
			{
				dottedOverlay:"none",
				delay:9000,
				startwidth:1170,
				startheight:600,
				hideThumbs:200,
				thumbWidth:100,
				thumbHeight:50,
				thumbAmount:5,
				navigationType:"none",
				navigationArrows:"solo",
				touchenabled:"on",
				onHoverStop:"on",
				swipe_velocity: 0.7,
				swipe_min_touches: 1,
				swipe_max_touches: 1,
				drag_block_vertical: false,
				keyboardNavigation:"on",
				navigationHAlign:"center",
				navigationVAlign:"bottom",
				navigationHOffset:0,
				navigationVOffset:20,
				soloArrowLeftHalign:"left",
				soloArrowLeftValign:"center",
				soloArrowLeftHOffset:20,
				soloArrowLeftVOffset:0,
				soloArrowRightHalign:"right",
				soloArrowRightValign:"center",
				soloArrowRightHOffset:20,
				soloArrowRightVOffset:0,
				shadow:0,
				fullWidth:"off",
				fullScreen:"off",
				spinner:"spinner2",
				stopLoop:"off",
				stopAfterLoops:-1,
				stopAtSlide:-1,
				shuffle:"off",
				autoHeight:"off",
				forceFullWidth:"off",
				hideThumbsOnMobile:"off",
				hideNavDelayOnMobile:1500,
				hideBulletsOnMobile:"off",
				hideArrowsOnMobile:"off",
				hideThumbsUnderResolution:0,
				hideSliderAtLimit:0,
				hideCaptionAtLimit:0,
				hideAllCaptionAtLilmit:0,
				startWithSlide:0
			});
		});	//ready

/* ==============================================
ACCORDION -->
=============================================== */

    function toggleChevron(e) {
        $(e.target)
            .prev('.panel-heading')
            .find("i.indicator")
            .toggleClass('fa-minus fa-plus');
    }
    $('.accordion').bind('hidden.bs.collapse', toggleChevron);
    $('.accordion').bind('shown.bs.collapse', toggleChevron);

/* ==============================================
SUB MENU -->
=============================================== */

	$('.dropdown-submenu > a').submenupicker();

/* ==============================================
MENU HOVER -->
=============================================== */

	$('.dropdown').hover(function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(300);
		}, function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(100).fadeOut(300);
	});

/* ==============================================
SEARCH -->
=============================================== */

	var $ctsearch = $( '#dmsearch' ),
		$ctsearchinput = $ctsearch.find('input.dmsearch-input'),
		$body = $('html,body'),
		openSearch = function() {
			$ctsearch.data('open',true).addClass('dmsearch-open');
			$ctsearchinput.focus();
			return false;
		},
		closeSearch = function() {
			$ctsearch.data('open',false).removeClass('dmsearch-open');
		};

	$ctsearchinput.on('click',function(e) { e.stopPropagation(); $ctsearch.data('open',true); });

	$ctsearch.on('click',function(e) {
		e.stopPropagation();
		if( !$ctsearch.data('open') ) {

			openSearch();

			$body.off( 'click' ).on( 'click', function(e) {
				closeSearch();
			} );

		}
		else {
			if( $ctsearchinput.val() === '' ) {
				closeSearch();
				return false;
			}
		}
	});
	
/* ==============================================
    Loader Effect
=============================================== */

    $(window).load(function() {
        $("#preloader").delay(500).fadeOut();
        $(".preloader").delay(600).fadeOut("slow");
    });

})(jQuery);