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
		<div class="col-lg-8 container">
			<form action="" method="post">
				<input type="hidden" value="${user.getId() }" name="id">
				<div class="form-group">
					<label for="userName">User Name:</label> <input name="name"
						type="text" value="${user.getUserName() }" class="form-control" id="userName"
						placeholder="Enter user name">
				</div>
				<div class="form-group">
					<label for="email">Email:</label> <input name="email" type="email"
						class="form-control" value="${user.getEmail() }" id="email" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input name="password"
						type="password" class="form-control" id="password"
						placeholder="Enter password or leave this empty for old one">
				</div>
				<div class="form-group">
					<label for="groupId">Group:</label> <select id="groupId"
						class="form-control" name="groupId">
						<option value="${group.getId() }" selected><c:out value="${group.getName() }"/></option>
						<c:forEach items="${groups}" var="gr">
							<option value="${gr.getId()}"><c:out
									value="${gr.getName()}" /></option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-dark">Submit</button>

			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>