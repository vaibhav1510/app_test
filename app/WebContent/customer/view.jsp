<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="home">
		<a href="index.jsp">Home</a>
	</div>
	<h1>Customer Details</h1>
	<div class="main">
		<div class="half left cf">
			<h2>${cust.name}</h2>
			<h2>${cust.email}</h2>
			<h2>${cust.phone}</h2>
			</br>
			<h2>${cust.address.city}&nbsp;${cust.address.pincode}</h2>
			<h2>${cust.address.state},&nbsp;${cust.address.country}</h2>
		</div>
		<div class="half right cf">
			<a href="update_customer?cust_id=${cust.id}">Modify</a>
		</div>
	</div>
</body>
</html>