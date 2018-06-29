<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Programmers School!</title>
</head>
<body>
	<%@ include file="/WEB-INF/fragments/header.jsp" %>
	<div class="containter">
		<div class="row">
			<div class="container col-lg-8">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Exercise:</th>
							<th scope="col">User:</th>
							<th scope="col">Updated:</th>
							<th scope="col">Details:</th>
					</thead>
					<tbody>
						<c:forEach items="${solutions}" var="solution" varStatus="stat">
							<tr>
								<th scope="row"><c:out value="${stat.count}" /></th>
								<td><c:out value="${exercises.get(stat.index)}" /></td>
								<td><c:out value="${users.get(stat.index)}" /></td>
								<td><c:out value="${solution.getUpdated()}" /></td>
								<td><a href="<c:url value="/solution-description?id=${solution.getId()}"/>">details</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp" %>
</body>
</html>
