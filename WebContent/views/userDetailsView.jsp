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
	<div class="containter">
		<div class="row">
			<div class="container col-lg-8">
				<table class="table">
					<tbody>
						<tr>
							<th scope="row">User name:</th>
							<td><c:out value="${user.getUserName()}" /></td>
						</tr>
						<tr>
							<th scope="row">Email:</th>
							<td><c:out value="${user.getEmail()}" /></td>
						</tr>
						<tr>
							<th scope="row">User Group:</th>
							<td><c:out value="${user.getUserGroup()}" /></td>
						</tr>
						<tr>
							<th scope="row">Solutions:</th>
							<td>
								<button type="button" class="btn btn-dark" data-toggle="modal"
									data-target="#myModal">Show solutions</button>
								<div class="modal fade" id="myModal">
									<div class="modal-dialog modal-dialog-centered">
										<div class="modal-content">

											<div class="modal-header">
												<h4 class="modal-title">
													<c:out value="${user.getUserName()}'s solutions for:" />
												</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<div class="modal-body">
												<div class="container">
													<div class="list-group">
														<c:forEach items="${solutions}" var="solution" varStatus="stat">
															<a
																href="<c:url value="/solution-description?id=${solution.getId()}"/>"
																class="list-group-item list-group-item-action list-group-item-dark"><c:out
																	value="${exercises.get(stat.index)}" /></a>
														</c:forEach>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>