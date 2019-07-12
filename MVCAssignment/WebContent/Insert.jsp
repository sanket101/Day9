<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Employee Details</title>
</head>
<body>
<h2>Insert Employee Details</h2>

<form action="InsertServlet" method="post">
  Name : <input type="text" name="name">
  <br>
  Number : <input type="text" name="number">
  <br>
  Role : <input type="text" name="role">
  <br>
  Password : <input type="password" name="psw">
  <br>
  Admin : <input type="text" name="isAdmin">
  <br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>