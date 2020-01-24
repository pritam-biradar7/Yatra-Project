<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Customer</title>
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
      <li class="active"><a href="../customer/login">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="./register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="./login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<h2 align="center" style="color:dodgerblue; font-family:times new roman; text-decoration: underline;text-shadow: 1px 1px grey;">Register Customer</h2>
<table align="center">

<tr>
	<td>
		<div class="form-group" >
    		<label for="Name">Name:</label>
    		<input type="text" class="form-control" id="name" name="name">
		</div>
	</td>
</tr>
<tr>
	<td>
			<div class="form-group">
    		<label for="email">Email address:</label>
    		<input type="email" class="form-control" id="email" name="email">
		</div>
 	</td>
 </tr>
 <tr>
 	<td>
 		<div class="form-group">
    		<label for="pwd">Password:</label>
    		<input type="password" class="form-control" id="password" name="password" >
		</div>
	</td>
</tr>
<tr>	
	<td>
		<div class="form-group">
    		<label for="mobile">Mobile No.:</label>
    		<input type="number" class="form-control" id="mobileno" name="mobileno">
		</div>
 	</td>
 </tr>
<tr><td>
	<input type="submit" class="btn btn-primary" value="Register">
	<input type="reset"  class="btn btn-danger" value="Cancel">
 </td></tr>
 </table>

</form>
</body>
</html>