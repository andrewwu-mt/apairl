<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->

<s:action name="product-get" executeResult="false">
	<s:param name="productId" value="#parameters.id" /> 
</s:action>
<s:action name="size-all" executeResult="false" />
<s:action name="type-all" executeResult="false" />

<head>
	<meta charset="utf-8">
	
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<title>${request.product.name}</title>
	<meta name="keywords" content="apairl,apairlstore,bikini,triangl,indonesia,baju,jual,dress,murah,asli,authentic,${request.product.name}">
	<meta name="description" content="${request.product.name}">
	<jsp:include page="core.jsp" />
</head>

<body>

	<jsp:include page="header.jsp" />
	
	<div id="main" role="main">
	
		<div class="container">
		
			<article id="seafolly-shimmer-tie-front-bustier" class="product hentry">
			
			<div class="row">
				<div class="col-md-12">
					
					<nav class="breadcrumb" role="navigation" aria-label="breadcrumbs">
					  <a href="index" title="Back to the frontpage">Home</a>
					
					    
					    <span aria-hidden="true">&rsaquo;</span>
					    <span>${request.product.name}</span>
					
					</nav>
					
				</div>
			</div>
			
			<div class="row">
				
				<div class="col-md-6 col-sm-6 product-images">
					
					<!-- The first image pulled from the product is a large image (480x480), subsequent images are "compact" which is 160x160 -->
					<div id="product_images">
							
							<!--
								<a href="//cdn.shopify.com/s/files/1/0271/9799/products/image1-a_1024x1024.jpg?v=1418211173" title="Seafolly Shimmer Tie Front Bustier" id="zoom1" class="cloud-zoom" rel="position: 'inside', showTitle: false">
									<img src="//cdn.shopify.com/s/files/1/0271/9799/products/image1-a_1024x1024.jpg?v=1418211173" alt="Seafolly Shimmer Tie Front Bustier" class="product-main-image"/>
								</a>
							-->
								
								
						<div class="featured-image-div">
							<img src="${request.product.thumbUrl}" alt="${request.product.name}" class="product-main-image" />
						</div>
						
						
						<div class="row">
							<ul id="product-thumbnails">
								
								<s:iterator value="#request.product.productUrls" status="st">
									<s:if test="%{#st.index == 0}">
										<li class="col-md-3 col-sm-4 alpha clearcolumn">
									</s:if>
									<s:elseif test="%{#st.index == #st.count-1}">
										<li class="col-md-3 col-sm-4 omega">
									</s:elseif>
									<s:else>
										<li class="col-md-3 col-sm-4">
									</s:else>
										<a href="${urlPath}" title="${product.name}" class="image-swap">
											<img src="${urlPath}" alt="${product.name}" />
										</a>
									</li>
								</s:iterator>
								
							</ul>
						</div>
						
						
					</div>
					
					<div id="mobile-product-images">
					
					<ul id="product-thumbnails">
					
						<s:iterator value="#request.product.productUrls" status="st">
							<s:if test="%{#st.index == 0}">
								<li class="two columns alpha clearcolumn">
							</s:if>
							<s:elseif test="%{#st.index == #st.count-1}">
								<li class="two columns omega">
							</s:elseif>
							<s:else>
								<li class="two columns">
							</s:else>
								<img src="${urlPath}" alt="${product.name}" />
							</li>
						</s:iterator>
						
					</ul>
					
					
					</div>
				
				</div>
					
				<div class="col-md-6 col-sm-6">
					
				<section class="entry-content">
				
					<h1 class="custom-font product-description-header">${request.product.name}</h1>
								
					<div class="product-description-wrapper">
						<s:property value="%{#request.product.description}" escape="false"/>
					</div>
					
					
					<form action="cart-add" method="post">
		
				        <div id="product-variants">
				        	<div class="selector-wrapper">
				        		<s:if test="%{#request.product.isSeparate == 0}">
				        			<label for="product-select-option-0">Size</label>
				        			<s:select list="%{#request.sizeList}" name="sizeId" listKey="sizeId" listValue="value" />
					        	</s:if>
				              	<s:else>
				        			<label for="product-select-option-0">Size Top</label>
				        			<s:select list="%{#request.sizeList}" name="sizeId" listKey="sizeId" listValue="value" />
				        			
				        			<label for="product-select-option-0">Size Bottom</label>
				        			<s:select list="%{#request.sizeList}" name="sizeId" listKey="sizeId" listValue="value" />
				              	</s:else>
			        		</div>
				        
				        </div>
		
				      
				      <h3 class="custom-font" id="price-field"></h3>
						
					  <input type="submit" name="add" value="Add to Cart" id="purchase" class="btn btn-success" />
					
					</form>
		
				</section>
				
				</div>
			
			</div>
			
			</article>
					
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
	 
</body>

</html>