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
<u><h2><i>Select Country</i></h2></u>
<select name="cId">
<c:forEach var="l" items="${sessionScope.country_list}">
<option value="${l.cId}">${l.name}
</c:forEach>
</select><br><br>
<input type="submit" value="Select">
</form>
</body>
</html>