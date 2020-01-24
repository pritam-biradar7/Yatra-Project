<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Holiday Planner</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../country/list">Home</a></li>
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
      <li><a href="./register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="./login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
<h4 style="color: red;">${requestScope.mesg}</h4>
<form  method="post">		
	
	<div class="col-xs-3">
		<div class="form-group">
    		<label for="email">Email address:</label>
    		<input type="email" class="form-control" id="email" name="em">
 		</div>
 	</div>
 	<div class="col-xs-3">
 		<div class="form-group">
    		<label for="pwd">Password:</label>
    		<input type="password" class="form-control" id="password" name="password" >
		</div>
	</div><br>
	<input type="submit" class="btn btn-primary" value="Login">
	<a href="./register">Register Customer</a>
</form>
</body>
</html>