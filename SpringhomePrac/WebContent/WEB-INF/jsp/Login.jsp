<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BLOGSJ</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/Styles.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	 <script src="resources/javascriptTools.js"></script>
	   <script src="resources/jquery.flexibleArea.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<body>

<form:form action="Login">
<div class="form-group">
  <label for="usr"> User Name:</label>
  <input type="text" name = "userName" class="form-control" id="usr">
</div>
<br>
<div class="form-group">
  <label for="pwd">Password:</label>
  <input type="password" name="password" class="form-control" id="pwd">
</div>

<button type="submit" class="btn btn-primary">Log in</button>


</form:form>
<br>
<form action="CreateNewAccount">


<button type="submit" class="btn btn-info">Create New Account</button>



</form>

<br>

<c:out value="${msg}"/>
</body>
</html>