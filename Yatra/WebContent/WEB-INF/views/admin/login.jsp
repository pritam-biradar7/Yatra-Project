<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<form  method="post">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Holiday Planner</a>
    </div>
  
    <ul class="nav navbar-nav navbar-right">
      <li><a href="./login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>


		<table align="center">
			<tr><td>
			<div class="form-group">
    			<label for="email">Email address:</label>
    			<input type="email" class="form-control" id="email" name="email">
 			</div></td>
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
				<td ><input type="submit" class="btn btn-primary" value="Login" />
				     <input type="reset"  class="btn btn-danger" value="Cancel">
				</td>
			</tr>
			<tr><td>
			<h4 style="color: red;">${requestScope.mesg}</h4>
			</td></tr>
		</table>
	</form>
</body>
</html>