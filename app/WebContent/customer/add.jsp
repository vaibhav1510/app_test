<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<div class="home">
		<a href="../index.jsp">Home</a>
	</div>
	<h1>Add New Customer</h1>
	<form class="cf" action="../add_customer" method="post">
		<div class="half left cf">
			<input type="text" id="input-name" placeholder="Name" name="name"> 
			<input type="email" id="input-email" placeholder="Email address" name="email"> 
			<input type="text" id="input-phone" placeholder="Phone" name="phone">
		</div>
		<div class="half right cf">
			<h2>Address</h2>
			<!--textarea name="message" type="text" id="input-message" placeholder="Message"></textarea-->
			<input type="text" id="input-city" placeholder="City" name="city"> 
			<input type="text" id="input-state" placeholder="State" name="state"> 
			<input type="text" id="input-country" placeholder="Country" name="country"> 
			<input type="text" id="input-pincode" placeholder="Pincode" name="pincode">
		</div>
		<input type="submit" value="Submit" id="input-submit">
	</form>
</body>
</html>