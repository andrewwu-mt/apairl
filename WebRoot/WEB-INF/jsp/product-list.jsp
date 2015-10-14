<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--><html lang="en"> <!--<![endif]-->

<s:action name="product-all" executeResult="false"></s:action>

<head>
	<meta charset="utf-8">
	
	<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<title>Apairl Store | Catalog</title>
	<meta name="keywords" content="apairl,apairlstore,bikini,triangl,indonesia,baju,jual,dress,murah,asli,authentic">
	<meta name="description" content="All Products">
	<jsp:include page="core.jsp" />
</head>

<body>

	<jsp:include page="header.jsp" />
	<div id="main" role="main">
	
		<div class="container">
			
			<div id="collections-main" class="all">
		
	<div class="title-bar custom-font collection-header">
		
			<h2>Products</h2>
		
		<div class="clear"></div>
	</div>
	
	<div id="collection-description">
		
			<div class="clear"></div>
	
	</div>
	
	  <section class="clearfix">
 
 	        <ul class="product-grid clearfix">
 	        	<s:set var="idx" value="0"/>
 	        	
				<s:iterator value="#request.productList" status="st" >
					<s:if test="%{#st.index == 0 || #st.index%4 == 0}">
						<li class="col-md-3 alpha col-sm-3 col-xs-12">
					</s:if>
					<s:elseif test="%{#st.index == 3+(4*#idx)}">
 	        			<s:set var="idx" value="%{#idx+1}"/>
						<li class="col-md-3 omega col-sm-3 col-xs-12">
					</s:elseif>
					<s:else>
						<li class="col-md-3 col-sm-3 col-xs-12">
					</s:else>
					
				  		<div class="indiv-product">
							<a href="product-detail?id=${productId}" title="${name}">
								<img src="${thumbUrl}" alt="${name}" class="animated fadeIn" id="collection-image-anim">
							</a>
							<div class="hp-title">
								<a href="product-detail?id=${productId}">
									<div class="indiv-product-title-text">${name}</div>
										<span class="custom-font compare-at-price">
											<small></small> &#36;${priceCompare}
										</span>
										<span class="money-styling custom-font">
											<small></small> &#36;${price}
										</span>
								</a>
							</div>
						</div>
					</li>
				</s:iterator>
				
	        </ul>
	        
			<!-- <div class="pagination">
				<ul>
					<li class="prev disabled"><a href="#" onclick="return false;">&laquo; Previous</a></li>
					
					<li class="active pagination-number"><a href="#" title="">1</a></li>
					<li class="pagination-number"><a href="all4658.html?page=2" title="">2</a></li>
					<li class="pagination-number"><a href="all9ba9.html?page=3" title="">3</a></li>
					
					<li class="pagination-arrow"><a href="all4658.html?page=2" title="Next"><i class="fa fa-chevron-right"></i></a></li>
				</ul>
			</div> -->

	  </section>
	  
	</div> <!-- /#col-main -->
			
			
		</div>
		
	</div>

	<jsp:include page="footer.jsp" />

</body>

</html>