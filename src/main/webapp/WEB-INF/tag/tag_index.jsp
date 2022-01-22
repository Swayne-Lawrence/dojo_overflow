<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<p>
		Question:  <c:out value="${question.question }"></c:out>
	</p>
	
	<p> <c:forEach var="l" items="${question.tags }"> 
			<c:out value="${l.subject }"></c:out>,
		</c:forEach> 
	</p>
	
	<form:form action="/tag_form/${question.id}" method="post" modelAttribute="tag">
		<form:input type="hidden" path="id" value="${num}"/>
		<p>
		<form:label path="subject">Tags</form:label>
		<form:input path="subject"/>
		<form:errors path="subject"></form:errors>
		</p>
		<button type="submit">Add</button>
	</form:form>
	<form action="/question_show">
		<button type="submit">Save</button>
	</form>
	

</body>
</html>