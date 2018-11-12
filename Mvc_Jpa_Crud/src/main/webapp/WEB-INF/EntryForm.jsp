<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
       
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error{
color:red;
}

</style>
</head>
<body>
<a href="EntryForm?lang=en">English</a>
<a href="EntryForm?lang=fr">French</a>
<form:errors path="*"></form:errors>
<form:form action="addEmp" modelAttribute="emp" method="post">
<table>
<tr> 
	<td><spring:message code="label.eid"/></td>
	<td><input type="text" name="eid"></td>
</tr>
<tr>
	<td><spring:message code="label.name"/></td>
	<td><input type="text" name="name"></td>
	<td><form:errors path="name" cssClass="error"></form:errors></td>
</tr>
<tr>
	<td><spring:message code="label.email"/></td>
	<td><input type="text" name="email" required></td>
	<td><form:errors path="email" cssClass="error"></form:errors></td>
</tr>
<tr>
	<td><spring:message code="label.password"/></td>
	<td><input type="password" name="password"></td>
	<td><form:errors path="password" cssClass="error"></form:errors></td>
</tr>
<tr>
 	<td><spring:message code="label.contact"/></td>
 	<td><input type="text" name="contact"></td>
 	<td><form:errors path="contact" cssClass="error"></form:errors></td>
 </tr>
 </table>
<input type="submit" value="submit">
</form:form>
</body>
</html>