<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.models.Customer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<h1>Test App</h1>
	<div class="main">
		<div class="half right cf">
			<a href="customer/add.jsp">Add New Customer</a>
		</div>
		<div class="half left cf">
			<form action="search_customer" method="post">
					<input type="text" placeholder="Search Email" name="search_email" id="search-input"> 
					<input type="submit" id="search-submit" value="">
			</form>			
		</div>
		<div class="tabl">
			<ul>
				<c:forEach var="cust" items="${listCusts}">
					<li>${cust.name}(${cust.email})<a
						href="view_customer?cust_id=${cust.id}">View</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>