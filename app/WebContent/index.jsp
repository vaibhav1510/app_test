<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
<h1>Add New Customer</h1>
<form class="cf">
  <div class="half left cf">
    <input type="text" id="input-name" placeholder="Name">
    <input type="email" id="input-email" placeholder="Email address">

    <input type="text" id="input-phone" placeholder="Phone">
  </div>
  <div class="half right cf">
    <h2>Address</h2>
    <!--textarea name="message" type="text" id="input-message" placeholder="Message"></textarea-->
    <input type="text" id="input-city" placeholder="City">
        <input type="text" id="input-state" placeholder="State">
        <input type="text" id="input-country" placeholder="Country">
        <input type="text" id="input-pincode" placeholder="Pincode">
  </div>  
  <input type="submit" value="Submit" id="input-submit">
</form>
</body>
</html>