<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Deletion</title>
</head>
<body>
<h2>Delete Details</h2><br><br>
<h3>Id : ${emp.getEmp_id()}</h3>
<br>
<h3>Name : ${emp.getName()}</h3>
<br>
<h3>Number : ${emp.getNumber()}</h3>
<br>
<h3>Is this the employee you want to delete?</h3>
<br>
<form action="ConfirmDeleteServlet" method="post">
  Id : <input type="number" name="id">
  <br>
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