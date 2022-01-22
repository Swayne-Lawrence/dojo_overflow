<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Question DashBoard</h1>
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="q" items="${questions}">
				<tr>
					<td> <a href="/answers/${q.id }"><c:out value="${q.question }"></c:out></a></td>
					<td>
						<c:forEach var="t" items="${q.tags }">
							<c:out value="${t.subject }"></c:out>,
						</c:forEach>
					 </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<a href="/">New Question</a>
</body>
</html>