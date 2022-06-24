<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MHACard LVB</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/toastr/toastr.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs5/dt-1.12.1/datatables.min.css" />
<style>
.content {
	position: absolute;
	left: 50%;
	top: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

#logo {
	width: auto;
	height: 150px;
	border-radius: 50%;
	object-fit: cover;
}
</style>
</head>

<body style="font-family: NotoSan; background-color: #f5f7fa">
	<div class="container">

		<div class="col-md-6 offset-md-3">
			<div class="text-center" style="padding-top: 140px;">
				<img id="logo"
					src="${pageContext.request.contextPath}/image/main_logo.jpg"
					class="shadow">
			</div>
			<div class="content">
				<c:if test="${flashError!=null}">
					<div class="alert alert-danger fw-bold" role="alert">
						<b>!!${flashError}</b>
					</div>
				</c:if>
				<div class="card shadow" style="width: 500px">
					<div
						class="card-header fs-3 bg-primary text-white text-center fw-bold">MHACard
						System</div>
					<div class="card-body">
						<form action="${pageContext.request.contextPath }/login"
							method="post">
							<div class="mb-3 row">
								<label for="staticEmail" class="col-sm-3 col-form-label fs-4">ອີເມວ</label>
								<div class="col-sm-9">
									<input type="text" name="email" id="email"
										class="form-control form-control-lg text-center"
										id="inputPassword" placeholder="example@email.com">
								</div>
							</div>
							<div class="mb-3 row">
								<label for="inputPassword" class="col-sm-3 col-form-label fs-4">ລະຫັດຜ່ານ</label>
								<div class="col-sm-9">
									<input type="password" name="password" id="password"
										class="form-control form-control-lg text-center"
										id="inputPassword">
								</div>
							</div>
							<div class="mb-1 row">
								<label for="inputPassword" class="col-sm-3 col-form-label"></label>
								<div class="col-sm-9 text-center">
									<button type="submit" class="btn btn-primary btn-lg">ເຂົ້າສູ່ລະບົບ</button>
								</div>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/fontAwsome5.js"
		type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/toastr/toastr.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/bs5/dt-1.12.1/datatables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#person').DataTable();
		});
		toastr.options = {
			"closeButton" : false,
			"debug" : false,
			"newestOnTop" : false,
			"progressBar" : true,
			"positionClass" : "toast-bottom-right",
			"preventDuplicates" : false,
			"onclick" : null,
			"showDuration" : "1200",
			"hideDuration" : "1000",
			"timeOut" : "5000",
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		}
	</script>
	<%@include file="../layout/toastrMessage.jsp"%>
</body>

</html>