<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${list.size()>0 && list.get(0) ne null}">
<form:form action="delEmp" modelAttribute="emp" method="post">
<table border="1">
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Contact</th>
<c:forEach begin="0" end="${list.size()-1}" var="i" >
<tr>
	<td>  <c:out value="${list.get(i).getEid()}"> </c:out>   </td>
	<td> <c:out value="${list.get(i).getName()}"></c:out> </td>
	<td> <c:out value="${list.get(i).getEmail()}"></c:out> </td>
	<td> <c:out value="${list.get(i).getContact()}"></c:out> </td>
	<td><button type="submit" value="${ list.get(i).getEid()}" name="del">Delete</button></td>
</tr>
</c:forEach>
</table>
</form:form>

<form action="updateForm" method="get">
Enter Id to Edit:<input type="text" name="id">
<input type="submit" value="Edit">
</form>
</c:if>
<c:if test="${list.size() eq 0 || list.get(0) eq null}">
<spring:message code="label.nodata"/>
<form action="Display">
<input type="submit" value="Back"> 
</form>
</c:if>
</body>
</html>