<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="find" method="post">
Find by LastName:<input type="text" name="lname">
<input type="submit" value="submit"></form>
<form action="find" method="post">
Find by FirstName:<input type="text" name="fname">
<input type="submit" value="submit"></form>
<form action="find" method="post">
Find by id:<input type="text" name="id">
<input type="submit" value="submit"></form>

<form action="Retrieve" method="post">
Retrieve by id:<input type="text" name="id">
<input type="submit" value="submit"></form>
<form action="Retrieve" method="post">
Retrieve by lname:<input type="text" name="lname">
<input type="submit" value="submit"></form>


<form action="delete" method="post">
delete by FirstName:<input type="text" name="fname">
<input type="submit" value="submit"></form>
<form action="delete" method="post">
delete by id:<input type="text" name="id">
<input type="submit" value="submit"></form>
</body>
</html>