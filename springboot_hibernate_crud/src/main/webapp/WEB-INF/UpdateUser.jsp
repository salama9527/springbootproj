<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<table>
<tr>
	<td>Id:</td>
	<td><input type="text" name="uid" value="${user.getUid() }" disabled></td>
	
	<td><input type="hidden" name="uid" value="${user.getUid() }"></td>
</tr>
<tr>
	<td>name:</td>
	<td><input type="text" name="userName" value="${user.getUserName() }"></td>
	
</tr>
<tr>
	<td>E-mail</td>
	<td><input type="text" name="email" value="${user.getEmail() }"></td>
	
</tr>
<tr>
	<td>Age</td>
	<td><input type="text" name="age" value="${user.getAge() }"></td>
	
</tr>
 </table>
 
<input type="submit" value="update">
</form>
</body>
</html>