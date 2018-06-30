<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/fragments/header.jsp"%>
	<div class="container">
		<div class="list-group">
			<a href="<c:url value="/panel/groups"/>"
				class="list-group-item list-group-item-action list-group-item-dark"><c:out
					value="Groups managment" /></a> <a
				href="<c:url value="/panel/users"/>"
				class="list-group-item list-group-item-action list-group-item-dark"><c:out
					value="Users managment" /></a> <a
				href="<c:url value="/panel/exercises"/>"
				class="list-group-item list-group-item-action list-group-item-dark"><c:out
					value="Exercises managment" /></a>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>