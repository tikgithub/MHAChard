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
<link rel="stylesheet" href="${pageContext.request.contextPath}/toastr/toastr.min.css">
<style>

</style>
</head>
<body style="font-family: NotoSan; background-color: #555566">
	<nav class="navbar navbar-dark bg-primary fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand fw-bold"
				href="${pageContext.request.contextPath}/"> <img
				src="image/main_logo.jpg" alt="" width="40" height="40"
				class="d-inline-block rounded-circle"> LVB MHACard
			</a>
			<span class="text-white">
				<b class="fs-6">User: jack@gmail.com</b> 
			</span>
		</div>
	</nav>
			
<div class="sidenav shadow">
  <a href="${pageContext.request.contextPath}/"><i class="fas fa-home me-1"></i>ໜ້າທຳອິດ</a>
  <hr class="text-white">
  <a href="${pageContext.request.contextPath}/getCardDataByDocNumber"><i class="fas fa-satellite-dish me-1"></i>ດຶງຂໍ້ມູນຈາກກະຊວງ</a>
  <a href="${pageContext.request.contextPath}/newListData"><i class="fas fa-clipboard-list me-1"></i>ເບິ່ງລາຍການພິມບັດ</a>
 <hr class="text-white">
  <a href="#contact"><i class="fas fa-clipboard-check me-1"></i>ລາຍງານພິມບັດຂອງ BCEL</a>
  <hr class="text-white">
  <div class="fixed-bottom text-white">
	  <div class="row">
		  <div class="col-12">
			 <a href="#logout" class="btn btn-danger" style="width: 200px;"><i class="fas fa-power-off me-2"></i> ອອກຈາກລະບົບ</a>
		  </div>
	  </div>
  </div>
</div>


	