<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:action name="product-all" executeResult="false" />

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->


<!-- Mirrored from templatevisual.com/demo/pathos/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Jul 2015 14:53:47 GMT -->
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<meta name="keywords" content="">

	<title>Pathos | eCommerce HTML Template</title>

    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/apple-touch-icon-114x114.png">

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/stroke.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/animate.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-submenu.min.css">
	<link rel="stylesheet" type="text/css" href="css/carousel.css">
	<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css">
	<link rel="stylesheet" type="text/css" href="css/content_slider_style.css">
	<link rel="stylesheet" type="text/css" href="rs-plugin/css/settings.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="style.css">

	<!-- COLORS -->
	<link rel="stylesheet" type="text/css" href="css/custom.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!--[if gte IE 9]>
	  <style type="text/css">
	    .gradient {
	       filter: none;
	    }
	  </style>
	<![endif]-->

</head>
<body>

    <div id="preloader">
        <div id="spinner"></div>
        <img class="preloader" src="images/loader.gif" alt="">
    </div><!-- end loader -->
    
	<div id="wrapper">
		<header class="header">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container">
				    <!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-brand-centered">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
						</button>
						<div class="navbar-brand navbar-brand-centered">
							<a href="index-2.html"><img src="images/logo.png" alt=""></a>
						</div>
				    </div>
				    <!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="navbar-brand-centered">
						<ul class="nav navbar-nav">
					        <li><a href="index-2.html">Home</a></li>
							<li class="dropdown"><a href="categories.html" tabindex="0" data-toggle="dropdown">Category <span class="fa fa-angle-down"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="categories.html" tabindex="0">DENIM SHIRT</a></li>
									<li><a href="categories.html" tabindex="0">SHORT SLEEVE SHIRT</a></li>
									<li><a href="categories.html" tabindex="0">BLAZERS</a></li>
									<li><a href="categories.html" tabindex="0">JACKET</a></li>
									<li><a href="categories.html" tabindex="0">DENIM SHIRT</a></li>
									<li><a href="categories.html" tabindex="0">SHORT SLEEVE SHIRT</a></li>
								</ul>
							</li>
							<li class="dropdown"><a href="#" tabindex="0" data-toggle="dropdown">Pages <span class="fa fa-angle-down"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="page-fullwidth.html" tabindex="0">Fullwidth</a></li>
									<li><a href="page-sidebar.html" tabindex="0">Page Sidebar</a></li>
									<li><a href="404.html" tabindex="0">Not Found</a></li>
									<li><a href="elements.html" tabindex="0">Elements</a></li>
								</ul>
							</li>
					        <li><a href="categories.html">Accessories</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" tabindex="0" data-toggle="dropdown">Shop <span class="fa fa-angle-down"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="categories.html" tabindex="0">Shop Default</a></li>
									<li><a href="shop-sidebar.html" tabindex="0">Shop Sidebar</a></li>
									<li><a href="shop-cart.html" tabindex="0">Shopping Cart</a></li>
									<li><a href="shop-checkout.html" tabindex="0">Shop Checkout</a></li>
									<li><a href="shop-single.html" tabindex="0">Shop Single</a></li>
								</ul>
							</li>
					        <li><a href="blog.html">Blog</a></li>
					        <li><a href="contact.html">Contact</a></li>	
							<li class="dropdown"><a class="cart" href="#" tabindex="0" data-toggle="dropdown"><span class="yellow">3</span> $1.245</a>
								<ul class="dropdown-menu" role="menu">
									<li class="shopcart">
										<table class="table">
											<tbody>
												<tr class="row">
									            <td class="col-md-3"><img src="upload/cart_01.png" class="img-responsive" alt=""></td>
									            <td class="col-md-7">
									            	<h4>AUTUMN WINTER</h4>
									            	<small> Woman Dress</small>
									            	<span class="old">$25.00</span>
									            	<span class="new">$12.00</span>
									            </td>
									            <td class="col-md-2"><a href="#" class="closeme"><i class="fa fa-close"></i></a></td>
												</tr>

												<tr class="row">
									            <td class="col-md-3"><img src="upload/cart_02.png" class="img-responsive" alt=""></td>
									            <td class="col-md-7">
									            	<h4>BLACK SABBAT</h4>
									            	<small> Woman Dress</small>
									            	<span class="old">$25.00</span>
									            	<span class="new">$12.00</span>
									            </td>
									            <td class="col-md-2"><a href="#" class="closeme"><i class="fa fa-close"></i></a></td>
												</tr>
											</tbody>
										</table>
										<div class="text-center">
											<h4>Total : $24.00</h4>
										</div><!-- end text-center -->
										<div class="cart-buttons row-fluid">
											<div class="col-md-6">
												<a href="#" class="btn btn-primary btn-block"><i class="fa fa-shopping-cart"></i> VIEW CART</a>
											</div>
											<div class="col-md-6">
												<a href="#" class="btn btn-primary btn-block btn-second">Checkout <i class="fa fa-angle-right"></i></a>
											</div>
										</div>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<div class="a">
									<div id="dmsearch" class="dmsearch">
										<form id="searchform" method="get">
											<span class="dm-search-container">
												<input id="s" class="dmsearch-input" type="text" name="s" value="" placeholder="Search on the site...">
						                    </span>
											<input id="go" class="dmsearch-submit" type="submit" value="">
											<i class="fa fa-search"></i>
										</form> <!-- end searchform -->
									</div><!-- end search -->
								</div>
							</li>
						</ul>
					</div><!-- /.navbar-collapse -->
				</div><!-- /.container-fluid -->
			</nav>
		</header>
		<div class="header-after"></div>

		<div class="header-bottom">
			<div class="headerpirice">
				<a href="#"><img src="images/dollar.png" alt=""></a> 
			</div>
		</div>

		<section class="slider-section boxedcontainer">
			<div class="tp-banner-container">
				<div class="tp-banner">
					<ul>
						<li data-transition="slidevertical" data-slotamount="1" data-masterspeed="500" data-thumb="upload/slider_bg.gif" data-saveperformance="off" data-title="Water Spirit">
							<img src="upload/slider_bg.gif"  alt="" data-bgposition="center bottom" data-bgfit="cover" data-bgrepeat="no-repeat">
                            <!-- LAYER NR.1 -->
                            <div class="tp-caption lft customout rs-parallaxlevel-0"
                                data-x="0"
                                data-y="50" 
                                data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                                data-speed="700"
                                data-start="1100"
                                data-easing="Power3.easeInOut"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                style="z-index: 4;"><img src="images/dummy.png" alt="" data-lazyload="upload/slider_01.png">
                            </div>
							<!-- LAYER NR. 2 -->
                            <div class="tp-caption slider_01 skewfromright randomrotateout tp-resizeme"
                                data-x="620"
                                data-y="140" 
                                data-speed="1000"
                                data-start="1000"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;"><img src="images/dummy.png" alt="" data-lazyload="upload/slider_02.png"> Midnight Collection
                            </div>
							<!-- LAYER NR. 3 -->
                            <div class="tp-caption slider_02 skewfromright randomrotateout tp-resizeme"
                                data-x="620"
                                data-y="190" 
                                data-speed="1000"
                                data-start="1300"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">FASHION TRENDS <span>2016</span>
                            </div>
							<!-- LAYER NR. 4 -->
                            <div class="tp-caption slider_03 skewfromright randomrotateout tp-resizeme"
                                data-x="624"
                                data-y="255" 
                                data-speed="1000"
                                data-start="1600"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">LUXURY SHIRTS FOR CONFIDENT WOMENS
                            </div>
                            <!-- LAYER NR.5 -->
                            <div class="tp-caption lft customout rs-parallaxlevel-0"
                                data-x="623"
                                data-y="287" 
                                data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                                data-speed="700"
                                data-start="1100"
                                data-easing="Power3.easeInOut"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                style="z-index: 4;"><img src="images/dummy.png" alt="" data-lazyload="upload/slider_03.png">
                            </div>
							<!-- LAYER NR. 6 -->
                            <div class="tp-caption slider_04 skewfromright randomrotateout tp-resizeme"
                                data-x="624"
                                data-y="325" 
                                data-speed="1000"
                                data-start="1800"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">ORDER MORE THAN $100 & GET UP TO <span>50%</span> OFF
                            </div>
							<!-- LAYER NR. 7 -->
                            <div class="tp-caption slider_button_01 skewfromright randomrotateout tp-resizeme"
                                data-x="624"
                                data-y="380" 
                                data-speed="1000"
                                data-start="2000"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;"><a href="#">Shop Now</a>
                            </div>
						</li>
						<li data-transition="slidevertical" data-slotamount="1" data-masterspeed="500" data-thumb="upload/slider_bg.gif" data-saveperformance="off" data-title="Water Spirit">
							<img src="upload/slider_bg.gif"  alt="" data-bgposition="center bottom" data-bgfit="cover" data-bgrepeat="no-repeat">
                            <!-- LAYER NR.1 -->
                            <div class="tp-caption lft customout rs-parallaxlevel-0"
                                data-x="600"
                                data-y="0" 
                                data-customout="x:0;y:0;z:0;rotationX:0;rotationY:0;rotationZ:0;scaleX:0.75;scaleY:0.75;skewX:0;skewY:0;opacity:0;transformPerspective:600;transformOrigin:50% 50%;"
                                data-speed="700"
                                data-start="1100"
                                data-easing="Power3.easeInOut"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                style="z-index: 4;"><img src="images/dummy.png" alt="" data-lazyload="upload/slider_04.png">
                            </div>
							<!-- LAYER NR. 2 -->
                            <div class="tp-caption slider_01 skewfromright randomrotateout tp-resizeme"
                                data-x="120"
                                data-y="140" 
                                data-speed="1000"
                                data-start="1000"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;"><img src="images/dummy.png" alt="" data-lazyload="upload/slider_05.png"> Collection
                            </div>
							<!-- LAYER NR. 3 -->
                            <div class="tp-caption slider_02 skewfromright randomrotateout tp-resizeme"
                                data-x="120"
                                data-y="190" 
                                data-speed="1000"
                                data-start="1300"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">WEEKEND BIGGEST SALE
                            </div>
							<!-- LAYER NR. 4 -->
                            <div class="tp-caption slider_03 lightcolor skewfromright randomrotateout tp-resizeme"
                                data-x="124"
                                data-y="265" 
                                data-speed="1000"
                                data-start="1600"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">FASHION COMMUNICATIONS<br> ACROSS THE MEDIA ONLINE
                            </div>
							<!-- LAYER NR. 5 -->
                            <div class="tp-caption slider_05 skewfromright randomrotateout tp-resizeme"
                                data-x="315"
                                data-y="255" 
                                data-speed="1000"
                                data-start="1800"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;">FANCY DRESS
                            </div>
							<!-- LAYER NR. 7 -->
                            <div class="tp-caption slider_button_02 skewfromright randomrotateout tp-resizeme"
                                data-x="340"
                                data-y="350" 
                                data-speed="1000"
                                data-start="2000"
                                data-easing="Power3.easeInOut"
                                data-splitin="none"
                                data-splitout="none"
                                data-elementdelay="0.1"
                                data-endelementdelay="0.1"
                                data-endspeed="1000"
                                style="z-index: 9; max-width: auto; max-height: auto; white-space: nowrap;"><a href="#">SHOP CLOTH & ACCESSORIES <i class="fa fa-angle-right"></i></a>
                            </div>
						</li>
					</ul>
				</div>
			</div>
		</section>
		
		<section class="section white">
			<div class="slider-after"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-duration="1s" data-wow-delay="0.2s">
						<a href="#"><img src="upload/left-banner.png" alt="" class="img-responsive"></a>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-duration="1s" data-wow-delay="0.4s">
						<a href="#"><img src="upload/middle-banner.png" alt="" class="img-responsive"></a>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-duration="1s" data-wow-delay="0.6s">
						<a href="#"><img src="upload/right-banner.png" alt="" class="img-responsive"></a>
					</div>
				</div><!-- end row -->

				<hr class="light">

				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="service-box">
							<img src="images/icon_01.png" alt="" class="alignleft wow fadeIn" data-wow-duration="1s" data-wow-delay="0.2s">
							<h4>FAST DELIVERY</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
						</div><!-- end service-box -->
					</div><!-- end col -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="service-box">
							<img src="images/icon_02.png" alt="" class="alignleft wow fadeIn" data-wow-duration="1s" data-wow-delay="0.4s">
							<h4>FASHION FOR MEN & WOMEN</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
						</div><!-- end service-box -->
					</div><!-- end col -->
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="service-box">
							<img src="images/icon_03.png" alt="" class="alignleft wow fadeIn" data-wow-duration="1s" data-wow-delay="0.6s">
							<h4>CONTACT US</h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
						</div><!-- end service-box -->
					</div><!-- end col -->
				</div><!-- end row -->
			</div><!-- end container -->
		</section><!-- end section -->

		<section class="section white withbg">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title text-center">
							<h2><span>Best</span> Sellers</h2>
							<h4>RECENT PRODUCTS</h4>
						</div><!-- end title -->
					</div><!-- end 12 -->
				</div><!-- end row -->

				<hr class="light">

				<div class="row">
					<div class="col-md-12">
						<div id="customtab">
						  <!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
							    <li role="presentation" class="active"><a href="#tab1" class="active" aria-controls="tab1" role="tab" data-toggle="tab">NEW ITEMS</a></li>
							    <li role="presentation"><a href="#tab2" aria-controls="tab2" role="tab" data-toggle="tab">BEST SELLERS</a></li>
							    <li role="presentation"><a href="#tab3" aria-controls="tab3" role="tab" data-toggle="tab">BRAND</a></li>
							    <li role="presentation"><a href="#tab4" aria-controls="tab4" role="tab" data-toggle="tab">TRENDING</a></li>
							</ul>

						  	<!-- Tab panes -->
							<div class="tab-content">
							    <div role="tabpanel" class="tab-pane active" id="tab1">
							    	<div class="row">
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_07.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BLACK SABBAT <span>Women Dress</span></a></h4>
								    				<span class="new">$12.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_08.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">AUTUMN WINTER <span>Women Dress</span></a></h4>
								    				<span class="new">$17.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_09.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BRIEFT BLACK <span>Women Dress</span></a></h4>
								    				<span class="new">$10.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_10.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">FLUSAS FEMININ <span>Women Dress</span></a></h4>
								    				<span class="new">$15.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    	</div>
							    </div><!-- end tabpanel -->
							  
							    <div role="tabpanel" class="tab-pane" id="tab2">
							    	<div class="row">
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_09.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BRIEFT BLACK <span>Women Dress</span></a></h4>
								    				<span class="new">$10.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_10.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">FLUSAS FEMININ <span>Women Dress</span></a></h4>
								    				<span class="new">$15.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_07.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BLACK SABBAT <span>Women Dress</span></a></h4>
								    				<span class="new">$12.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_08.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">AUTUMN WINTER <span>Women Dress</span></a></h4>
								    				<span class="new">$17.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    	</div>
							    </div><!-- end tabpanel -->

							    <div role="tabpanel" class="tab-pane" id="tab3">
							    	<div class="row">
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_10.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">FLUSAS FEMININ <span>Women Dress</span></a></h4>
								    				<span class="new">$15.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_09.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BRIEFT BLACK <span>Women Dress</span></a></h4>
								    				<span class="new">$10.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_07.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BLACK SABBAT <span>Women Dress</span></a></h4>
								    				<span class="new">$12.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_08.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">AUTUMN WINTER <span>Women Dress</span></a></h4>
								    				<span class="new">$17.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    	</div>
							    </div><!-- end tabpanel -->

							    <div role="tabpanel" class="tab-pane" id="tab4">
							    	<div class="row">
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_10.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">FLUSAS FEMININ <span>Women Dress</span></a></h4>
								    				<span class="new">$15.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_07.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BLACK SABBAT <span>Women Dress</span></a></h4>
								    				<span class="new">$12.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_09.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">BRIEFT BLACK <span>Women Dress</span></a></h4>
								    				<span class="new">$10.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    		<div class="col-md-3 col-md-6 col-xs-12">
							    			<div class="shop-item-tab">
							    				<div class="entry">
							    					<img src="upload/shop_08.png" alt="" class="img-responsive">
							    					<div class="magnifier">
							    						<div class="visible-buttons">
							    							<div class="shopbuttons">
								    							<a class="magnibutton" href="shop-single.html" title=""><i class="fa fa-search"></i></a>
								    							<a class="readbutton" href="shop-single.html" title=""><i class="fa fa-check-square-o "></i> Ready Stock</a>
								    							<a class="cartbutton" href="shop-cart.html" title=""><i class="icon icon-ShoppingCart"></i></a>
								    						</div>
							    						</div><!-- end visible-buttons -->
							    					</div><!-- end magnifier -->
							    				</div><!-- entry -->
							    				<div class="shop-item-desc text-center">
								    				<h4><a href="shop-single.html">AUTUMN WINTER <span>Women Dress</span></a></h4>
								    				<span class="new">$17.00</span>
												</div><!-- end desc -->
							    			</div><!-- end shop-item-tab -->
							    		</div>
							    	</div>
							    </div><!-- end tabpanel -->



							</div><!-- end tab-content -->
						</div><!-- end customtab -->
					</div><!-- end 12 -->
				</div><!-- end row -->
			</div><!-- end container -->
		</section><!-- end section -->

		<section class="section white nopadding">
			<div class="ads-after"></div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12 nopadding bigbanner wow fadeInLeft" data-wow-duration="1s" data-wow-delay="0.2s">
						<a href="#"><img src="upload/banner-left.png" alt="" class="img-responsive"></a>
					</div><!-- end 12 -->
					<div class="col-md-6 col-sm-6 col-xs-12 nopadding bigbanner wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.2s">
						<a href="#"><img src="upload/banner-right.png" alt="" class="img-responsive"></a>
					</div><!-- end 12 -->
				</div><!-- end row -->
			</div><!-- end container -->
		</section><!-- end section -->

		<section class="section white">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title text-center">
							<h2><span>Promo</span> Information</h2>
							<h4>MONHTLY SPECIAL OFFER</h4>
							<h5>Start from 2 June 2015 - end 2 July 2015</h5>
						</div><!-- end title -->
					</div><!-- end 12 -->
				</div><!-- end row -->

				<hr class="light">

				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.2s">
							<a href="#"><img src="upload/shop_01.png" alt="" class="img-responsive alignleft"></a>
							<h4>VERSUS VERSACE <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.4s">
							<a href="#"><img src="upload/shop_02.png" alt="" class="img-responsive alignleft"></a>
							<h4>AUTUMN WINTER <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.6s">
							<a href="#"><img src="upload/shop_03.png" alt="" class="img-responsive alignleft"></a>
							<h4>FLUSAS FEMININ <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
				</div><!-- end row -->

				<hr class="light">

				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.2s">
							<a href="#"><img src="upload/shop_04.png" alt="" class="img-responsive alignleft"></a>
							<h4>BLACK SABBAT <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.4s">
							<a href="#"><img src="upload/shop_05.png" alt="" class="img-responsive alignleft"></a>
							<h4>AUTUMN WINTER <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<div class="shop-item wow fadeIn" data-wow-duration="1s" data-wow-delay="0.6s">
							<a href="#"><img src="upload/shop_06.png" alt="" class="img-responsive alignleft"></a>
							<h4>FLUSAS FEMININ <span>Women Dress</span></h4>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
							<div class="price">
							<span class="old">$25.00</span>
							<span class="new">$12.00</span>
							</div>
							<a href="#" class="btn btn-sm btn-primary btn-border"><i class="icon icon-ShoppingCart"></i> Cart</a>
						</div><!-- end shop item -->
					</div>
				</div><!-- end row -->
			</div><!-- end container -->
		</section><!-- end section -->

		<section class="section grey">
			<div class="ads-after"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title text-center">
							<h2><span>News</span> from blog</h2>
							<h4>Latest News</h4>
							<h5>All news about fashion 2015 - 2016</h5>
						</div><!-- end title -->
					</div><!-- end 12 -->
				</div><!-- end row -->

				<hr class="light">
				<hr class="light">
				<hr class="light">

				<div id="owl-blog" class="">
					<div class="owl-blog-item">
						<div class="row-fluid">
							<div class="col-md-6 col-sm-6 col-xs-12 nopadding">
								<div class="blog-image">
									<a href="single.html"><img src="upload/blog_01.png" alt="" class="img-responsive"></a>
									<span class="date">20</span>
								</div><!-- end blog image -->
							</div><!-- end col -->

							<div class="col-md-6 col-sm-6 col-xs-12 nopadding white">
								<div class="blog-desc">
									<span class="comments-count"><a href="#"><i class="fa fa-comments"> 1.452</i></a></span>
									<span class="date">APRIL<br>2015</span>
									<h4><a href="single.html">THELIST: SUMMER’S FOLK SCENE</a></h4>
									<p>Artisanal handiworks are the pieces de resist  this summer</p>
									<a href="#" class="btn btn-sm btn-default btn-border">MORE</a>
								</div><!-- end blog image -->
							</div><!-- end col -->
						</div><!-- end row -->
					</div><!-- end row -->

					<div class="owl-blog-item">
						<div class="row-fluid">
							<div class="col-md-6 col-sm-6 col-xs-12 nopadding">
								<div class="blog-image">
									<a href="single.html"><img src="upload/blog_02.png" alt="" class="img-responsive"></a>
									<span class="date">20</span>
								</div><!-- end blog image -->
							</div><!-- end col -->

							<div class="col-md-6 col-sm-6 col-xs-12 nopadding white">
								<div class="blog-desc">
									<span class="comments-count"><a href="#"><i class="fa fa-comments"> 1.452</i></a></span>
									<span class="date">APRIL<br>2015</span>
									<h4><a href="single.html">THELIST: SUMMER’S FOLK SCENE</a></h4>
									<p>Artisanal handiworks are the pieces de resist  this summer</p>
									<a href="#" class="btn btn-sm btn-default btn-border">MORE</a>
								</div><!-- end blog image -->
							</div><!-- end col -->
						</div><!-- end row -->
					</div><!-- end row -->
				</div><!-- end owl -->
			</div><!-- end container -->
		</section><!-- end section -->

		<section class="parallax" data-parallax="scroll" data-image-src="upload/parallax_01.jpg">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-title text-center">
							<h2><span>What</span> They said</h2>
							<h4>Testimonial</h4>
						</div><!-- end title -->
					</div><!-- end 12 -->
				</div><!-- end row -->

				<hr class="light">

				<div class="content_slider_wrapper" id="slider1">
					<div class="circle_slider_text_wrapper" id="sw0" style="display: none;">
						<div class="content_slider_text_block_wrap">
							<h3>Caterina Wilson <span>COMPANY.INC</span></h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
						</div>
						<div class="clear"></div>	
					</div>
					<div class="circle_slider_text_wrapper" id="sw1" style="display: none;">
					<!-- content for the second layer, id="sw1" -->
						<div class="content_slider_text_block_wrap">
							<h3>Caterina Wilson <span>COMPANY.INC</span></h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
						</div>
						<div class="clear"></div>	
					</div>
					<div class="circle_slider_text_wrapper" id="sw2" style="display: none;">
						<div class="content_slider_text_block_wrap">
							<h3>Caterina Wilson <span>COMPANY.INC</span></h3>
							<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
						</div>
						<div class="clear"></div>	
					</div>
				</div>

			</div><!-- end container -->
		</section><!-- end section -->

		<section class="section white littlepadding">
			<div class="container">
				<div id="owl-client">
					<div class="owl-client-item">
						<a href="#"><img src="upload/client_01.png" alt="" class="img-responsive"></a>
					</div><!-- end owl item -->

					<div class="owl-client-item">
						<a href="#"><img src="upload/client_02.png" alt="" class="img-responsive"></a>
					</div><!-- end owl item -->

					<div class="owl-client-item">
						<a href="#"><img src="upload/client_03.png" alt="" class="img-responsive"></a>
					</div><!-- end owl item -->

					<div class="owl-client-item">
						<a href="#"><img src="upload/client_04.png" alt="" class="img-responsive"></a>
					</div><!-- end owl item -->

					<div class="owl-client-item">
						<a href="#"><img src="upload/client_05.png" alt="" class="img-responsive"></a>
					</div><!-- end owl item -->
				</div><!-- end owl -->
			</div><!-- end container -->
		</section><!-- end section -->

		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="widget">
							<div class="widget-title">
								<h4>NEWSLETTER SUBSCRIBE</h4>
							</div><!-- end widget-title -->
							<div class="newsletter">
							<p>Lorem ipsum dolor sit amet, cons adipiscing elit, sed diam nonumy dolor.</p>
							<form class="form-inline">
								<div class="form-group">
							    <div class="input-group">
									<input type="text" class="form-control" id="exampleInputAmount" placeholder="Your Email">
									<div class="input-group-addon"><i class="icon icon-Mail"></i></div>
							    </div>
								</div>
							</form>
							</div><!-- end newsletter -->
						</div><!-- end widget -->
					</div><!-- end col -->

					<div class="col-md-2 col-sm-6 col-xs-12">
						<div class="widget">
							<div class="widget-title">
								<h4>MY ACCOUNT</h4>
							</div><!-- end widget-title -->
							<ul>
								<li><a href="#">My Account</a></li>
								<li><a href="#">Personal Information</a></li>
								<li><a href="#">Address</a></li>
								<li><a href="#">Discount</a></li>
								<li><a href="#">Order Hstory</a></li>
								<li><a href="#">My Credit Slip</a></li>
							</ul>
						</div><!-- end widget -->
					</div><!-- end col -->

					<div class="col-md-2 col-sm-6 col-xs-12">
						<div class="widget">
							<div class="widget-title">
								<h4>OUR SERVICES</h4>
							</div><!-- end widget-title -->
							<ul>
								<li><a href="#">Shipping & Return</a></li>
								<li><a href="#">international Shipping</a></li>
								<li><a href="#">Secure Shopping</a></li>
								<li><a href="#">Affliates</a></li>
								<li><a href="#">Careers</a></li>
								<li><a href="#">FAQ</a></li>
							</ul>
						</div><!-- end widget -->
					</div><!-- end col -->

					<div class="col-md-2 col-sm-6 col-xs-12">
						<div class="widget">
							<div class="widget-title">
								<h4>INFORMATION</h4>
							</div><!-- end widget-title -->
							<ul>
								<li><a href="#">New Products</a></li>
								<li><a href="#">Top Seller</a></li>
								<li><a href="#">Special</a></li>
								<li><a href="#">Manufacturer</a></li>
								<li><a href="#">Suppliers</a></li>
								<li><a href="#">Our Stores</a></li>
							</ul>
						</div><!-- end widget -->
					</div><!-- end col -->

					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="widget">
							<div class="widget-title">
								<h4>CONTACT US</h4>
							</div><!-- end widget-title -->

							<div class="contact-details">
								<p>Lorem ipsum dolor sit amet, cons<br> adipiscing elit.</p>
								<ul>
									<li><i class="fa fa-map-marker"></i> 404 DESIGNER,  NEW YORK</li>
									<li><i class="icon icon-Mail"></i> INFO@PHATOS.COM</li>
									<li><i class="icon icon-Phone"></i> +100 - 800 - 456789</li>
								</ul>
								<div class="social">
									<a href="#"><i class="fa fa-facebook"></i></a>
									<a href="#"><i class="fa fa-twitter"></i></a>
									<a href="#"><i class="fa fa-google-plus"></i></a>
									<a href="#"><i class="fa fa-linkedin"></i></a>
								</div><!-- end social -->
							</div>
						</div><!-- end widget -->
					</div><!-- end col -->
				</div><!-- end row -->
			</div><!-- end container -->
		</footer><!-- end footer -->

		<div class="copyrights">
			<div class="container">	
				<div class="row clearfix">
					<div class="col-md-6">
						<p>Copyright © <a href="#">Pathos Fashion 2015</a>. All Right Reserved</p>
					</div>
					<div class="col-md-6">
						<img src="images/payments.png" alt="" class="img-responsive">
					</div>
				</div><!-- end row -->
			</div><!-- end container -->
		</div>

	</div><!-- end wrapper -->

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-submenu.min.js"></script>
	<script src="js/retina.js"></script>
	<script src="js/wow.js"></script>
	<script src="js/parallax.js"></script>
	<script src="js/carousel.js"></script>
	<script src="js/jquery.content_slider.min.js" type="text/javascript"></script>
	<script src="js/jquery.mousewheel.js" type="text/javascript"></script>
	<script src="js/jquery.prettyPhoto.js" type="text/javascript" charset="utf-8"></script>
	<script src="rs-plugin/js/jquery.themepunch.tools.min.js"></script>
    <script src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
	<script src="js/custom.js"></script>

</body>

<!-- Mirrored from templatevisual.com/demo/pathos/ by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Jul 2015 14:56:23 GMT -->
</html>