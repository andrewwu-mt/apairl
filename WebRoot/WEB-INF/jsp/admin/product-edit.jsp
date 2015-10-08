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
<s:action name="category-all" namespace="/" executeResult="false" />
<s:action name="size-all" namespace="/" executeResult="false" />
<s:action name="product-get" namespace="/" executeResult="false">
	<s:param name="productId" value="#parameters.id" /> 
</s:action>

</head>
<body>
	<div id="content" align="center">
	
		<table class="list">
			<s:form action="product-update" validate="true" id="doupdate" cssClass="list2" namespace="admin" >
				<s:hidden name="productId" value="%{#request.product.productId}" />
			
				<tr>
					<th>Field</th>
					<th>Value</th>
				</tr>
				
				<s:select list="%{#request.categoryList}" name="categoryId" listKey="categoryId" listValue="name" label="Category" value="%{#request.product.category.categoryId}" />
				<s:textfield name="name" label="Name" size="50" value="%{#request.product.name}" />
				<s:textfield name="price" label="Price" size="50" value="%{#request.product.price}" />
				<s:textfield name="priceCompare" label="Compare with price" size="50" value="%{#request.product.priceCompare}" />
	 			<tr>
	  		    	<td>Separate</td>
					<s:if test="%{#request.product.isSeparate == 1}">
		  		    	<td>True</td>
					</s:if>
					<s:else>
		  		    	<td>False</td>
					</s:else>
	  		    </tr>
				<s:select name="active" label="Active" list="#{'1':'True', '0':'False'}" value="%{#request.product.active}" />
				<s:textarea name="description" label="Description" value="%{#request.product.description}" cssStyle="resize:none;height:100px;width:500px" />
				
	 			<tr>
	  		    	<td colspan="2" align="right"><div class="button-wrapper"><button class="submit">Submit</button></div></td>
	  		    </tr>
			</s:form>
		</table>
		
		
		<table class="list">
			<s:form cssClass="list2" action="product-url-save" method="POST" enctype="multipart/form-data" namespace="admin">
				<s:hidden name="productId" value="%{#request.product.productId}" />
				<tr>
					<th colspan="2">Upload images</th>
				</tr>
				<tr>
					<td>Image</td>
					<td>
						<s:file name="fileUpload" theme="simple" multiple="multiple"/>
					    <s:submit value="Upload" />
					</td>
				</tr>
			</s:form>
		</table>
		
		<br>
		<br>
		
	</div>  

</body>