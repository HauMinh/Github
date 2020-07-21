<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>history list</title>
</head>
<body>
        <h2 style ="text-align: center; color:blue;">HISTORY LIST</h2>
   <table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>id history</th>
			<th>id user</th>
			<th>id product</th>
			<th> total</th>
		
			<th>Delete</th>	
            			
		</tr>
		<c:forEach items="${historyList}" var="history">
			<tr>
				<td>${history.idhistory}</td>
				<td>${history.iduser}</td>
				<td>${history.idproduct}</td>
				<td>${history.total}</td>
			 
			 	<td><a href="deleteHistory?idhistory=${history.idhistory}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	        <td> 
               <a href="home">Cancel </a> 
            </td>
</body>
</html>