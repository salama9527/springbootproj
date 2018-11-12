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
<form action="updateEmp" method="post">
<table>
<tr>
	<td>Id:</td>
	<td><input type="text" name="eid" value="${emp.getEid() }" disabled></td>
	<td><form:errors path="eid" cssClass="error"></form:errors></td>
	<td><input type="hidden" name="id" value="${emp.getEid() }"></td>
</tr>
<tr>
	<td>name:</td>
	<td><input type="text" name="name" value="${emp.getName() }"></td>
	<td><form:errors path="name" cssClass="error"></form:errors></td>
</tr>
<tr>
	<td>E-mail</td>
	<td><input type="text" name="email" value="${emp.getEmail() }"></td>
	<td><form:errors path="email" cssClass="error"></form:errors></td>
</tr>
<tr>
	<td>Password</td>
	<td><input type="password" name="password" value="${emp.getPassword() }"></td>
	<td><form:errors path="eid" cssClass="error"></form:errors></td>
</tr>
<tr>
 	<td>Contact</td>
 	<td><input type="text" name="contact" value="${emp.getContact()}"></td>
 	<td><form:errors path="contact" cssClass="error" ></form:errors></td>
 </tr>
 </table>
<input type="submit" value="update">
</form>
</body>
</html>