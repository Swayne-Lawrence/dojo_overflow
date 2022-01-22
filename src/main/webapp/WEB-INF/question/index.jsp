<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>What is your question?</h1>
	<form:form action="/form" method="post" modelAttribute="quest">
		<p>
			<form:label path="question">Question:</form:label>
			<form:textarea path="question"/>
			<form:errors path="question"></form:errors>
		</p>
		<button type="submit">Submit</button>
	</form:form>
	<a href="/question_show">DashBoard</a>
</body>
</html>