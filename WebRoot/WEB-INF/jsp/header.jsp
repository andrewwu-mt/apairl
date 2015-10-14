<div id="mobile-navigation">
	<nav class="nav">
		<ul>
			<li><strong><a href="checkout">Checkout</a></strong></li>
			<li><a href="index">Home</a></li>
			<li><a href="category-list">Catalog</a></li>
<!-- 			<li><a href="blogs/news.html">Blog</a></li> -->
			<li><a href="about-us">About Us</a></li>
<!-- 			<li><a href="account/login.html">My Account</a></li> -->
<!-- 			<li><a href="account/logout.html" id="customer_logout_link">Log out</a></li> -->
		</ul>
	</nav>
</div> 

<header id="site-header" class="clearfix custom-font">

<div class="container visible-xs">
	<div class="row">
		<div class="col-xs-2">
			<a id="responsive-menu-button" href="#sidr-mobile">
				<i class="fa fa-bars fa-3x"></i>
			</a>
		</div>
		<div class="col-xs-10">
			<form id="search" action="https://envy-stockholm.myshopify.com/search">
			<div id="search-wrapper">
				<input id="search_text" name="q" type="text" size="20" onblur="if(this.value=='')this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value='';" value="Search"/>
				<input id="search_submit" type="submit" border="0" value="&#xf002;" />
				<div class="clear"></div>
			</div>
			</form>
		</div>
	</div>
</div>

<div class="container hidden-xs">

<div class="row">
		<div class="col-md-7 col-sm-12">
			<nav class="navbar" role="navigation">
				<div>
					<ul class="nav navbar-nav">
					    <li><a href="index">Home</a></li>
					    <li><a href="product-list">Catalog</a></li>
<!-- 					    <li><a href="blogs/news.html">Blog</a></li> -->
					    <li><a href="about-us">About Us</a></li>
<!-- 			      		<li class="customer-account-links"> -->
<!-- 			        		<a href="account/login.html" id="customer_login_link">Log in</a> -->
<!-- 	        				<li><a href="account/register.html" id="customer_register_link">Create Account</a></li> -->
<!-- 			      		</li> -->
				    </ul>
				</div>
			</nav>
		</div>
		
		<div class="col-md-3 col-sm-6">
		
			<form id="search" action="product-search" >
				<div id="search-wrapper">
					<input id="search_text" name="q" type="text" size="20" onblur="if(this.value=='')this.value=this.defaultValue;" onfocus="if(this.value==this.defaultValue)this.value='';" value="Search"/>
					<input id="search_submit" type="submit" border="0" value="&#xf002;" />
					<div class="clear"></div>
				</div>
			</form>
		
		</div>
		
		<div class="col-md-2 col-sm-6">
		
			<div id="cart-brief">                   
				<div class="cart-link">
			         <h4><a href="#sidr" class="custom-font slide-menu"><i class="fa fa-shopping-cart"></i> Your Cart</a></h4>
				</div>
			</div><!-- #cart-brief -->
		
		</div>
	
	</div>

</div><!-- .container -->

</header>

<div id="sidr" style="display: none;">
<!-- Your content -->
		<div>
			<h4><span class="cart-item-count">0</span></h4>
			<span class="cart-item-count-text">items in your cart</span>	
		</div>
		
		<div>
			<h4><span class="cart-item-price">&pound;0.00</span></h4>
			<span class="cart-item-price-text">total cart value</span>
		</div>
		
		<div class="slide-checkout-buttons">
			<a href="#sidr" class="btn btn-default slide-menu">Continue Shopping</a><br />
			<a href="cart.html" class="btn btn-default">Your Cart</a>
		</div>
	</ul>
</div> 

<div class="container" id="page-layout">

	<div class="row">
		<h1 id="site-title">
		  <a href="index" title="Home">
		      <img src="img/logo/logo-bg.png" alt="Apairl Store" /> 
		  </a>
		</h1>
	</div>
	
	<div class="row hidden-xs">
		<div class="product-nav-wrapper-main col-md-12">
			<div id="product-nav-wrapper" class="custom-font">
				<ul class="nav nav-pills">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<span class="nav-label">Fashion</span><span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="product-list">Beachwear</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>