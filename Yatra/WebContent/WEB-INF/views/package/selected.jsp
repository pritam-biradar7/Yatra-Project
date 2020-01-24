<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Package</title>
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
      <li><a href="../cart/showcart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
    </ul>
  </div>
</nav>
<form method="post">
<h2>Selected Packages </h2>
<div class="table-responsive">
<table class="table">
<tr>
	<th>Package Name</th>
	<th>Package Type</th>
	<th>Package Description</th>
	<th>Package Amount(Rs.)</th>
</tr>
	<c:forEach var="p" items="${sessionScope.Selected_Package}">
		<tr>
			<td><input type="checkbox" name="pId" value="${p.pId}">${p.pName} </td>
			<td>${p.pType}</td>
			<td>${p.pDesc}</td>
			<td>${p.pAmt}</td>
		</tr>
	</c:forEach>
</table>
</div>
<input type="submit" class="btn btn-success btn-block" value="Add to Cart">
</form>
</body>
</html>