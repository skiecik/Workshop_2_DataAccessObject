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
				<input type="hidden" value="${exercise.getId()}" name="id">
				<div class="form-group">
					<label for="title">Exercise title:</label> <input name="title"
						type="text" class="form-control" id="title"
						placeholder="Enter title" value="${exercise.getTitle()}">
				</div>
				<div class="form-group">
					<label for="description">Description:</label>
					<textarea class="form-control" rows="4" id="description" name="description" placeholder="Enter description" >${exercise.getDescription()}</textarea>
				</div>
				<button type="submit" class="btn btn-dark">Submit</button>
			</form>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>