<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../country/list">Holiday Planner</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../customer/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="../customer/login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      <li><a href="./showcart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
  </div>
</nav>
<h1 style="color:dodgerblue; font-family:times new roman; text-decoration: underline;text-shadow: 1px 1px grey;">Cart</h1>
<form method="post">

<div class="table-responsive">
<table class="table">
<tr>
<th>Package Id</th>
<th>Package Name</th>
<th>Package Amount</th>
<th>Remove</th>
</tr>
<c:forEach var="cart" items="${sessionScope.cart}">

<tr>
<td>${cart.pId}</td>
<td>${cart.pName}</td>
<td><div class="amt">${cart.pAmt}</div></td>
<td><a href="<spring:url value='/cart/remove?pId=${cart.pId}'/>">Remove</a></td>
</tr>
</c:forEach>
<tr><td></td><th>Total:</th>
<td>${sessionScope.total}</td>
<td></td></tr>
<tr><td></td><td></td><td align="right"><input type="submit" class="btn btn-primary" value="Proceed To Payment"></td><td></td></tr>
</table>
</div>
</form>
</body>
</html>