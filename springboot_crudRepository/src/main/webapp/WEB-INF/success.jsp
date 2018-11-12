<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hey success
<table>
<th>id</th>
<th>FirstName</th>
<th>LastName</th>
<tr>
<td>${Employee.getId()}</td>
<td>${Employee.getFname()}</td>
<td>${Employee.getLname()}</td>
</tr>
</table>
</body>
</html>