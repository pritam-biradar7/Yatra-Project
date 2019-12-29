<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<c:forEach var="p" items="${sessionScope.Package_list}">
<input type="checkbox" name="${p.pName}" value="${p.pName}">${p.pName}- ${p.pType}- ${p.pDesc}- Rs.${p.pAmt}<br>
</c:forEach><br><br>
<input type="submit" value="Add to Cart">

</form>
</body>
</html>