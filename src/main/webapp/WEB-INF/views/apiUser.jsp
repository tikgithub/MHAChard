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
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">New API User</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">...</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
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
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="../layout/footer.jsp"%>