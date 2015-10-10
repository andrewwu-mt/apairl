<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="zh-TW">

<head>
<meta charset="UTF-8">
<jsp:include page="header-2.jsp"/>
<s:action name="stock-all" executeResult="false" />

<script>
$(document).ready(function(){
	$("#btn").click(function(){
		$("#doupdate").submit();	
	});
	
});
</script>
</head>
<body>
	<div id="content" align="center">
		<table class="list2">
			<caption>
				<h2>Inventory list</h2>
				<br>
				<a href="product-add">Add product</a>
				<br>
				<hr>
				<br>
			</caption>
			<tr>
				<th>Image</th>
				<th>Product name</th>
				<th>Category</th>
				<th>Type</th>
				<th>Size</th>
				<th>Price</th>
				<th>Price Compare</th>
				<th>Inventory</th>
				<th></th>
			</tr>
			
			<s:iterator value="#request.stockList">
				<s:form action="product-update-quick" method="POST" theme="simple">
					<s:hidden name="stockId" value="%{stockId}" />
					<tr>
						<td><img src="../${product.thumbUrl}" width="69" height="88"/></td>
		                <td><a href="product-edit?id=${product.productId}"><s:property value="%{product.name}" /></a></td>	   
						<td><s:property value="%{product.category.name}" /></td>		             
						<td><s:property value="%{type.name}" /></td>			                
						<td><s:property value="%{size.value}" /></td>			                
		                <td><fmt:formatNumber groupingUsed="true"><s:property value="%{product.price}" /></fmt:formatNumber></td>
		                <td><fmt:formatNumber groupingUsed="true"><s:property value="%{product.priceCompare}" /></fmt:formatNumber></td>
		                <td><s:textfield name="qty" value="%{qty}"/></td>
		                <td><s:submit value="Update" /></td>
	                </tr>
                </s:form>
			</s:iterator>
		</table>
	</div>  

</body>