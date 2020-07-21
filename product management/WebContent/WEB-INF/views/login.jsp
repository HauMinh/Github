<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="login.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 
</head>
<body style="background: url('images/anh1.jpg') no-repeat;background-size: cover;
	width: 100%;
	height: 100%;">
        <div class="wrap-form ">

		<form method="POST" action="${pageContext.request.contextPath}/loginUser"  style="background-color: transparent;" >
			<h1 class="title">LOGIN</h1>
			<h5 style="color: red;">${errormessage}</h5>
			
               <label>User name:</label>
               <input class="pl-3" type="text" name="username">
            
               <label>Password:</label>
               <input class="pl-3" type="password" name="password">
      				
      			<input type="checkbox">
      			<span>Remember me?</span><br>
				
				<div class="text-center mt-4">
            	<input class="btn btn-info px-3" type="submit" value="Login">  
            	</div>
                
                <div class="pt-2"><a href="#">Forgot password?</a></div>
            	<div><a href="${pageContext.request.contextPath}/createUser">Register a new membership</a></div>
		</form>  
	</div>
	     
</body>
</html>