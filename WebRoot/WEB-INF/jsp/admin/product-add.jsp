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

</head>
<body>
	<div id="content" align="center">
		<table class="list">
			<s:form action="product-save" cssClass="list2" method="POST" namespace="admin">
				<tr>
					<th>Field</th>
					<th>Value</th>
				</tr>
				<s:select list="%{#request.categoryList}" name="categoryId" listKey="categoryId" listValue="name" label="Category" />
				<s:textfield name="name" label="Name" size="50" />
				<s:textfield name="price" label="Price" size="50" />
				<s:textfield name="priceCompare" label="Compare with price" size="50" />
				<s:select name="isSeparate" label="Separate" list="#{'1':'True', '0':'False'}" />
				<s:select name="active" label="Active" list="#{'1':'True', '0':'False'}" />
				<s:textarea name="description" label="Description" cssStyle="resize:none;height:500px;width:500px" />
				<s:submit value="Create" />
			</s:form>
		</table>
	</div>  

</body>