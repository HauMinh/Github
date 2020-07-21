<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sell product</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
         <div class="wrap-form">
	<form method="POST" action="${pageContext.request.contextPath}/insertHistory">
	
         <table class="w-100 table_spacing">
         	<tr>
               <td class="table_name">Id product:</td>
               <td><input class="pl-3" type="text" name="idproduct" value="${product.idproduct}" readonly="readonly"/></td>
            </tr>
            <tr>
               <td class="table_name">Producer:</td>
               <td><input class="pl-3" type="text" name="producer" value="${product.producer}"readonly="readonly"/></td>
            </tr>
            <tr>
               <td class="table_name">Name:</td>
               <td><input class="pl-3" type="text" name="name" value="${product.name}"readonly="readonly"/></td>
            </tr>
            <tr>
               <td class="table_name">Total:</td>
               <td><input class="pl-3" type="text" name="total" value="${product.total}"readonly="readonly"/></td>
            </tr>
             <tr>
               <td class="table_name">Price:</td>
               <td><input class="pl-3" type="text" name="price" value="${product.price}"readonly="readonly"/></td>
            </tr>
     		<tr>
               <td class="table_name">Quantity of goods:</td>
               <td><input class="pl-3" type="number" name="amount"/></td>
            </tr>
            
         </table>
         <div class="text-center mt-4">
         	<input class="btn btn-success" type="submit" value="sell" />
         	<a class="btn btn-danger" href="${pageContext.request.contextPath}/productList">Cancel</a>
         </div>
         
      </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>      
       
</body>
</html>