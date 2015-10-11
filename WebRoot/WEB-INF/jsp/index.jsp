<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:action name="slide-all" executeResult="false" />

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->

<s:action name="featured-all" executeResult="false" />

<head>
	<meta charset="utf-8">
	
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<title>Apairl Store Indonesia</title>
	<meta name="keywords" content="apairl,apairlstore,bikini,triangl,indonesia,baju,jual,dress,murah,asli,authentic">
	<meta name="description" content="Menjual authentic Triangl Bikini dan berbagai macam pakaian wanita lain khusus wilayah Indonesia.">
	<jsp:include page="core.jsp" />
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<div id="main" role="main">
	
	<div class="container">
	
	<div class="row">
	
	<div class="flexslider-container col-lg-12">
		<div class="flexslider">
	    <ul class="slides">
	    	<s:iterator value="#request.slideList" >
		        <li>
		            <img src="${src}" alt="apairl-slide-${slideId}"/>
		        </li>
	    	</s:iterator>
	    </ul>
	  </div>
	</div>
	</div>
	
	<div id="hp-two-promoboxs" class="row">
	
		<div class="col-md-6 col-sm-6 col-xs-6">
			<img src="cdn.shopify.com/s/files/1/0271/9799/t/10/assets/promobox-item-1a3ee.jpg?1172313162436649993" alt="" />
		</div>
	
		<div class="col-md-6 col-sm-6 col-xs-6">
			<img src="cdn.shopify.com/s/files/1/0271/9799/t/10/assets/promobox-item-2a3ee.jpg?1172313162436649993" alt="" />
		</div>
	</div>
	
	<div id="featured" class="">
	
		<div class="title-bar custom-font">
			<h2>Featured Products</h2>
			<div class="clear"></div>
		</div>
	
		<div class="row">
			<ul class="featured-products">
				
				<s:iterator value="#request.featuredList" >
				
					<li class="col-md-3 col-sm-3 col-xs-12">
					<div class="indiv-product">
						<a href="product-detail?id=${product.productId}" title="${product.name}">
							<img src="${product.thumbUrl}" alt="${product.name}" class="animated fadeIn" id="collection-image-anim">
						</a>
						
						<div class="hp-title">
							<a href="product-detail?id=${product.productId}">
								<div class="indiv-product-title-text">${product.name}</div>
								<span class="custom-font compare-at-price">
									<small></small> &#36;${product.priceCompare}
								</span>
								<span class="money-styling custom-font">
									<small></small> &#36;${product.price}
								</span>
							</a>
						</div>
					</div>
				   	</li>
				   	
				</s:iterator>
			</ul>
		</div>
	</div>
	
	<div class="instagram-wrapper">
	
		<div class="title-bar custom-font">
			<h2><a target="_blank" href="http://www.instagram.com/apairlstore">Find us on Instagram</a></h2>
			<div class="clear"></div>
		</div>
		
		<div id="instafeed" class="row"></div>
	
	</div>
	
	
			
			
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp" />
	
	<script type="text/javascript">
	if($(window).width() > 768){
		$(document).ready(function(){
			var check_cookie = $.cookie('envy-welcome-popup');
			if(check_cookie == null){
				$.cookie('envy-welcome-popup', 'true', { expires: 7 });
				$.fancybox({
					href: "#envy-auto-popup-2",
					padding: 0
				});
			}
		});
	};
	</script>
	
	<script type="text/javascript">
	    var userFeed = new Instafeed({
	        get: 'user',
	        userId: 1445652193,
	        accessToken: '1445652193.7a705ff.1951a80bc4d5413e9285c86a577800fd',
	        template: '<div class="col-md-2 col-sm-2 col-xs-6" style="padding:10px;"><a class="fancybox-instagram" href="{{image}}"><img src="{{image}}" class="img-responsive"/></a></div>',        
	        limit: 24,
	        resolution: 'standard_resolution'
	    });
	    
	    userFeed.run();
	</script>
		
	<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation: "slide",
			directionNav: true,
			controlNav: false,
			controlsContainer: ".flexslider-container",
			startAt: 0,
			slideshowSpeed: 4000
	  });
	});
	</script>
	
	<script type="text/javascript" charset="utf-8">
	//<![CDATA[
	jQuery(function() {
	  jQuery('nav a').each(function() {
	    if (jQuery(this).attr('href')  ===  window.location.pathname) {
	      jQuery(this).addClass('current');
	    }
	  });
	});  
	//]]>
	</script>

</body>
</html>