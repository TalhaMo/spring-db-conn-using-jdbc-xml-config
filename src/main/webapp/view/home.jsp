<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/files/css/style.css"/>
</head>
<body>
	<h4>Home Page : List of users in the project</h4>
	<hr />
	<table border="1" align="left">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userId} </td>
				<td>${user.name} </td>
				<td>${user.email} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>