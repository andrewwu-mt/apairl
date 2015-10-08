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
		<s:form action="stock-update" theme="simple" method="post" id="doupdate">
				<caption>
					<h2>Inventory list</h2>
					<br>
					<input id="btn" type="button" value="Update" class="submit-rounded"/>
					<br>
					<a href="product-add">Add product</a>
					<br>
					<hr>
					<br>
				</caption>
				<tr>
					<th>Category</th>
					<th>Product name</th>
					<th>Type</th>
					<th>Size</th>
					<th>Price</th>
					<th>Price Compare</th>
					<th>Inventory</th>
					<th></th>
				</tr>
				
				<s:iterator value="stockList">
						<tr>
							<td><s:property value="%{product.category.name}" /></td>		
			                <td><a href="product-edit?id=${product.productId}"><s:property value="%{product.name}" /></a></td>	                
							<td><s:property value="%{type.name}" /></td>			                
							<td><s:property value="%{size}" /></td>			                
			                <td><fmt:formatNumber groupingUsed="true"><s:textfield name="price" value="%{product.price}" /></fmt:formatNumber></td>
			                <td><fmt:formatNumber groupingUsed="true"><s:textfield name="priceCompare" value="%{product.priceCompare}" /></fmt:formatNumber></td>
			                <td><s:textfield name="qty" value="%{qty}"/></td>
			                <td><a href="product-update-quick?stockId=${stockId}" >Update</a></td>
		                </tr>
				</s:iterator>
		</s:form>
			</table>
		<br>
		<br>
		<br>
		
				
	</div>  

</body>