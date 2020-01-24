<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Package List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form method="post">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Holiday Planner</a>
    </div>
  <ul class="nav navbar-nav">
      <li class="active"><a href="../admin/navigation">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../admin/login"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>

<h2 align="center" style="color:dodgerblue; font-family:times new roman; text-decoration: underline;text-shadow: 1px 1px grey;">List of Packages</h2>
<div class="table-responsive">
<table class="table">
<tr>
<th>Package Name</th>
<th>Package Type</th>
<th>Package Description</th>
<th>Package Amount(Rs.)</th>
<th>Delete</th>
<th>Update</th>
</tr>
<c:forEach var="p" items="${sessionScope.package_list}">
<tr>
<td>${p.pName}</td><td> ${p.pType}</td><td> ${p.pDesc}</td><td>${p.pAmt}</td>
<td><a href="<spring:url value='/package/delete?pId=${p.pId}'/>">Delete</a></td>
<td><a href="<spring:url value='/package/update?pId=${p.pId}'/>">Update</a></td>
</tr>
</c:forEach>

<tr><td></td><td></td><td align="center">
<input type="submit" class="btn btn-primary" value="Add New Packages">
</td><td></td><td></td></tr>
</table>
</div>
</form>
</body>
</html>