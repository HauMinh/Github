<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>productList</title>
</head>
<body>
      <h2 style ="text-align: center; color:blue;">PRODUCT LIST</h2>
   <table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>id product</th>
			<th>producer</th>
			<th>name</th>
			<th> total</th>
			<th>Price</th>
            <th>Delete</th>	
            <th>Update</th>
            <th>Sell</th>				
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.idproduct}</td>
				<td>${product.producer}</td>
				<td>${product.name}</td>
				<td>${product.total}</td>
			 	<td>${product.price}</td>
				 <td><a href="deleteProduct?idproduct=${product.idproduct}">Delete</a></td>
				 <td><a href="updateProduct?idproduct=${product.idproduct}">Update</a></td>
				 <td><a href="insertHistory?idproduct=${product.idproduct}">Sell</a></td>
			</tr>
		</c:forEach>
	</table>
	        <td> 
               <a href="home">Cancel </a> 
            </td>
</body>
</html>