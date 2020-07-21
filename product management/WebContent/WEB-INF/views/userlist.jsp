<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user list</title>
</head>
<body> 
        
       <h2 style ="text-align: center; color:blue;">USER LIST</h2>
   <table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>id user</th>
			<th>user name</th>
			<th>password</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.iduser}</td>
				<td>${user.username}</td>
				<td>${user.password}</td>
			
			</tr>
		</c:forEach>
	</table>
	        <td> 
               <a href="home">Cancel </a> 
            </td>

</body>
</html>