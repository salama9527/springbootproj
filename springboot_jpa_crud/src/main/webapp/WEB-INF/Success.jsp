<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${list.size()>0 && list.get(0) ne null}">
<form action="operation"  method="post">
<table border="1">
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Email</th>
<c:forEach begin="0" end="${list.size()-1}" var="i" >
<tr>
	<td>  <c:out value="${list.get(i).getUid()}"> </c:out>   </td>
	<td> <c:out value="${list.get(i).getUserName()}"></c:out> </td>
	<td> <c:out value="${list.get(i).getAge()}"></c:out> </td>
	<td> <c:out value="${list.get(i).getEmail()}"></c:out> </td>
	<td><button type="submit" value="${ list.get(i).getUid()}" name="delete">Delete</button></td>
	<td><button type="submit" value="${list.get(i).getUid()}" name="update">UpdateForm</button>
	</td>
</tr>
</c:forEach>
</table>
</form>
</c:if>

</body>
</html>