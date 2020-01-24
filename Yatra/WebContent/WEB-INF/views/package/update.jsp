<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Package</title>
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

<h2 align="center" style="color:dodgerblue; font-family:times new roman; text-decoration: underline;text-shadow: 1px 1px grey;">Update Package</h2>

<table align="center">

<tr>
	<td>
		<div class="form-group" >
    		<label for="pName">Package Name:</label>
    		<input type="text" class="form-control" id="pName" name="pName" value="${sessionScope.uPackage.pName}">
		</div>
	</td>
</tr>
<tr>
	<td>
			<div class="form-group">
    		<label for="pType">Package Type:</label>
    		<input type="text" class="form-control" id="pType" name="pType" value="${sessionScope.uPackage.pType}">
		</div>
 	</td>
 </tr>
 <tr>
 	<td>
 		<div class="form-group">
    		<label for="pDesc">Package Description:</label>
    		<input type="text" class="form-control" id="pDesc" name="pDesc" value="${sessionScope.uPackage.pDesc}">
		</div>
	</td>
</tr>
<tr>	
	<td>
		<div class="form-group">
    		<label for="pAmt">Package Amount:</label>
    		<input type="number" class="form-control" id="pAmt" name="pAmt" value="${sessionScope.uPackage.pAmt}">
		</div>
 	</td>
 </tr>
<tr>	
	<td>
	<div class="form-group">
		<label for="pcountry">Package Country:</label>
		<select name="cId">
			<option id="1" value="1">India</option>
			<option id="2" value="2">Egypt</option>
			<option id="3" value="3">Australia</option>
		</select>
	</div>
 	</td>
</tr>
 
<tr><td>
	<input type="submit" class="btn btn-primary" value="Update">
	<input type="reset"  class="btn btn-danger" value="Reset">
 </td></tr>
 </table>

</form>
</body>
</html>