<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="main">
	<div style="padding-top: 70px;"></div>

	<div class="container">
		<div class=row>
			<div class="col-md-6 offset-md-3 text-center">
				<h3 class="">API User</h3>
				<button type="button" class="btn btn-primary" data-bs-toggle="modal"
					data-bs-target="#addModal">
					<i class="fas fa-user me-3"></i>ສ້າງ User ໃໝ່
				</button>
				<div class="modal fade" id="addModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">New API User</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<form action="${pageContext.request.contextPath }/APIUser/store" method="post">
							<div class="modal-body">
								
									<div class="mb-3">
										<input type="email" class="form-control text-center form-control-lg" name="email" placeholder="Email">
									</div>
									<div class="mb-3">
										<input type="password" class="form-control text-center form-control-lg" name="password" placeholder="Password">
									</div>
								
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">ອອກ</button>
								<button type="submit" class="btn btn-primary">ບັນທຶກ</button>
							</div>
							</form>
						</div>
					</div>
				</div>
				<hr>
				<table id="person" class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Email</th>
							<th><i class="fas fa-cog"></i></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users }" varStatus="loop">
							<tr>
								<td>${(loop.index)+1 }</td>
								<td>${user.email }</td>
								<td>
									
									<a class="btn btn-danger" href="${pageContext.request.contextPath }/APIUser/delete/${user.email}"><i class="fas fa-trash-alt"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="../layout/footer.jsp"%>
<%@ include file="../layout/toastrMessage.jsp"%>