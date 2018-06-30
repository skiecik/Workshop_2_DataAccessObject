<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Programmers school!</title>
</head>
<body>
	<%@ include file="/WEB-INF/fragments/header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="card col-lg-4">
				<div class="card-header"><c:out value="${exercise.getTitle()}"/></div>
				<div class="card-body"><c:out value="${exercise.getDescription()}"/></div>
			</div>
			<div class="col-lg-8 text-center">
				<h3>
					Solution description: <br>
					<br>
				</h3>
				<c:out value="${solution.getDescription() }" />
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>