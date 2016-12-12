<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<div id="navigation"></div>
<h1>What do you want to write!</h1>

<form:form action="submit"  method="post">	

<section>
	<label for = "usr"> Date : </label>
	<div class = "form-group" style="width: 50%">
<!--	<input type = "date" class="form-control input-lg" id="usr"> -->
	<form:input path="date" style="border-radius: 10px; height : 50px; width :90%"/>
	
	
	</div>
	<label for = "tpc">Topic : </label>
	<div class = "form-group" style="width: 50%">
	<!--  	<input type = "text" class="form-control input-lg" id="tpc"> -->
	<form:input path="subject" style="border-radius: 10px; height : 50px; width :90%" />

	</div>

</section>
	<div class = "form-group"  id = "journal_div">
	<label for = "journal" > Journal : </label>	
	<br/>
		<textarea id = "journal" name="entry" wrap="off" style="border-radius: 10px; height : 50px; width :90%">		
		</textarea>
	</div>
		<input type="submit" value="Submit">
		
</form:form>

</body>
</html>