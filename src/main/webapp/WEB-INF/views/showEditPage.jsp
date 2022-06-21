<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../layout/header.jsp"%>

<div class="main">
	<div style="padding-top: 80px;"></div>
	<div class="pt-2"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<form action="${pageContent.request.contextPath }/">
					<div class="mb-3">
					  <label class="form-label">ເພດ</label>
					  <input type="text" name="sex" class="form-control" id="sex" value="${person.sex}">
					</div>
					<div class="mb-3">
					  <label class="form-label">ຊື່</label>
					  <input type="text" name="enFName" class="form-control" id="enFName" value="${person.enFName}">
					</div>
					<div class="mb-3">
					  <label class="form-label">ນາມສະກຸນ</label>
					  <input type="text" name="enLName" class="form-control" id="enLName" value="${person.enLname}">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
	<!-- Modal -->
	<%@include file="../layout/footer.jsp"%>
	<%@include file="../layout/toastrMessage.jsp"%>