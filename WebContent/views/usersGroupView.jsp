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
			<c:forEach items="${users}" var="user">
				<a href="<c:url value="/users/show?id=${user.getId()}"/>"
					class="list-group-item list-group-item-action list-group-item-dark d-flex justify-content-between align-items-center"><c:out
						value="${user.getUserName()}" /><span
					class="badge badge-primary badge-pill"><c:out
							value="${user.getEmail()}"></c:out></span></a>
			</c:forEach>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>