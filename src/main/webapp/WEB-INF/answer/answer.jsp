<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<%@ page isErrorPage="true" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${question.question }"></c:out></h1>
	<p>
		<c:forEach var="t" items="${question.tags }">
			<c:out value="${t.subject }"></c:out>,
		</c:forEach> 
	</p>
	<h2> Answers</h2>
	<c:forEach var="a" items="${question.answers }">
		<p> <c:out value="${a.answer }"></c:out></p>
	</c:forEach>
	
	<form:form action="/answer_form/${question.id }" method="post" modelAttribute="ans"> 
		<form:input path="question" type="hidden" value="${question.id }"/>
		<form:input path="id" type="hidden" value="${num}"/>
		<p> 
			<form:label path="answer">Answer</form:label>
			<form:textarea path="answer"/>
			<form:errors path="answer"></form:errors>
		</p>
			<button type="submit">Submit</button>
	</form:form>
</body>
</html>