<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create product</title>
<link rel="stylesheet" type="text/css" href="create.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
        
<div class="wrap-form">
    <form method="POST" action="${pageContext.request.contextPath}/createProduct">
        
         <h2 style ="text-align: center; color:blue;">CREATE PRODUCT</h2>
       <table class="w-100 table_spacing">
            <tr >
               <td class="table_name">Producer:</td>
               <td><input class="pl-3" type="text" name="producer"/></td>
            </tr>
            
            <tr>
               <td class="table_name">Name:</td>
               <td><input class="pl-3" type="text" name="name"/></td>
            </tr>
            
            <tr>
               <td class="table_name">Total:</td>
               <td><input class="pl-3" type="text" name="total"/></td>
            </tr>
            
             <tr>
               <td class="table_name">Price:</td>
               <td><input class="pl-3" type="text" name="price"/></td>
            </tr>
         </table>
         
         <div class="text-center mt-4">
         	<input class="btn btn-success" type="submit" value="Submit" />
         	<a class="btn btn-danger" href="${pageContext.request.contextPath}/home">Cancel</a>
         </div>
      </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
</body>
</html>