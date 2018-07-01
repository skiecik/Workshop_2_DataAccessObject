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
		<div class="row">
			<div class="container col-lg-8">
				<div class="list-group">
					<a href="<c:url value="/panel/users/add"/>"
						class="list-group-item list-group-item-action list-group-item-success text-center"><c:out
							value="Add new user" /></a>
				</div>

			</div>
		</div>
		<div class="row">
			<div class="container col-lg-8">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">UserName:</th>
							<th scope="col">Email </th>
							<th scope="col">Group</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user" varStatus="stat">
							<tr>
								<th scope="row"><c:out value="${stat.count}" /></th>
								<td><c:out value="${user.getUserName()}" /></td>
								<td><c:out value="${user.getEmail()}"/></td>
								<td><c:out value="${groups.get(stat.index)}"/></td>
								<td><a
									href="<c:url value="/panel/users/edit?id=${user.getId()}"/>"><button
											type="button" class="btn btn-primary">Edit</button> </a></td>
								<td>
									<button type="button" class="btn btn-danger"
										data-toggle="modal" data-target="#User${user.getId()}">Delete</button>
									<div class="modal fade" id="User${user.getId()}">
										<div class="modal-dialog modal-dialog-centered">
											<div class="modal-content">

												<div class="modal-header">
													<h4 class="modal-title">
														<c:out value="Are you sure you want to delete this group?" />
													</h4>
													<button type="button" class="close" data-dismiss="modal">&times;</button>
												</div>

												<div class="modal-body">
													<div class="container">
														<div class="row">
															<div class="col">
																<a
																	href="<c:url value="/panel/users/delete?id=${user.getId()}"/>"><button
																		type="button" class="btn btn-danger">Yes</button></a>
															</div>
															<div class="col">
																<button type="button" class="btn btn-dark"
																	data-dismiss="modal">No</button>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/fragments/footer.jsp"%>
</body>
</html>