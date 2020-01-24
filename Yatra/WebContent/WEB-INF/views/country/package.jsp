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
<form method="post">
<c:forEach var="p" items="${sessionScope.Package_list}">
<input type="checkbox" name="${p.pId}" value="${p.pName}">${p.pName}- ${p.pType}- ${p.pDesc}- Rs.${p.pAmt}<br>
</c:forEach><br><br>
<input type="submit" class="btn btn-default" value="Add to Cart">

</form>
</body>
</html>