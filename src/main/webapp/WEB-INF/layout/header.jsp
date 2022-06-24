<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
.blink_me {
	animation: blinker 3s linear infinite;
}

@
keyframes blinker { 50% {
	opacity: 0.5;
}
}
</style>
</head>
<body style="font-family: NotoSan; background-color: #f5f7fa">
	<nav class="navbar navbar-dark bg-primary fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand fw-bold"
				href="${pageContext.request.contextPath}/home"> <img
				src="${pageContext.request.contextPath}/image/main_logo.jpg" alt=""
				width="40" height="40" class="d-inline-block rounded-circle">
				LVB MHACard
			</a> <span class="text-white"> <b class="fs-6">User:
					<%= session.getAttribute("userLogin") %></b>
			</span>
		</div>
	</nav>

	<div class="sidenav shadow">
		<a href="${pageContext.request.contextPath}/home"><i
			class="fas fa-home me-3"></i>ໜ້າທຳອິດ</a>
		<hr class="text-white">
		<a href="${pageContext.request.contextPath}/getCardDataByDocNumber"><i
			class="fas fa-satellite-dish me-3"></i>ດຶງຂໍ້ມູນຈາກກະຊວງ</a> <a
			href="${pageContext.request.contextPath}/newListData"><i
			class="fas fa-clipboard-list me-3"></i>ເບິ່ງລາຍການພິມບັດ</a>
		<hr class="text-white">
		<a href="${pageContext.request.contextPath }/cardmonitor/search"><i class="fas fa-clipboard-check me-3"></i>ຕິດຕາມລາຍການພິມບັດ</a>
		<hr class="text-white">
		<a href="${pageContext.request.contextPath }/APIUser/"><i class="fas fa-clipboard-check me-3"></i>API User</a>
		<hr class="text-white">
		<div class="fixed-bottom text-white">
			<div class="row">
				<div class="col-12">
					<a href="${pageContext.request.contextPath }/logout" class="btn btn-danger" style="width: 200px;"><i
						class="fas fa-power-off me-2"></i> ອອກຈາກລະບົບ</a>
				</div>
			</div>
		</div>
	</div>