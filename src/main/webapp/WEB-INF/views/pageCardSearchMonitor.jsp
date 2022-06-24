<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<style>
.profile{
	width: auto;
	height: 70px;
}
</style>
<div class="main">
  <div class="pt-5"></div>
    <h3 class="pt-5 text-center" style="padding-top: 50px;">ກວດສອບສະຖານະການພິມບັດ</h3>
    <div class="row">
    	<div class="col-md-6 offset-md-3">
    		<form style="width: 400px; margin: auto;" method="post" action="${pageContext.request.contextPath}/cardmonitor/search">
    			<div class="mb-3">
    				<input type="text" class="form-control text-center form-control-lg" name="document_number" placeholder="ເລກທີ່ເອກະສານ" value="${document_number}">
    			</div>
    			<div class="mb-3 text-center">
    				<button type="submit" class="btn btn-primary"><i class="fas fa-search me-3"></i>ຄົ້ນຫາ</button>
    			</div>
    		</form>
    		<hr>
    		
    	</div>
    </div>
    <div class="container-fluid">
    	<table class="table table-hover" id="person">
    			<thead>
    				<tr>
    					<th>#</th>
    					<th>Photo</th>
    					<th>ຊື່ບັນຊີ</th>
    					<th>ເລກບັນຊີ</th>
    					<th>ເລກບັດ</th>
    					<th>ການພິມ</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach var="card" items="${cardList}" varStatus="loop">
    					<tr class="align-middle">
    						<td>${(loop.index) + 1}</td>
    						<td>
    							<img src="${card.photo}" class="profile">
    						</td>
    						<td>${card.account_name}</td>
    						<td>${card.account_number }</td>
    						<td>${card.atm_number}</td>
    						<td>
    							<c:if test="${card.print_status=='SUCCESS'}">
    								<span class="badge bg-success">${card.print_status}</span>
    							</c:if>
    							<c:if test="${card.print_status=='PRINTING'}">
    								<span class="badge bg-danger">${card.print_status}</span>
    							</c:if>
    							<c:if test="${card.print_status==null}">
    								<span class="badge bg-secondary">No Status</span>
    							</c:if>
    						</td>
    					</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    </div>
</div>
<%@include file="../layout/footer.jsp"%>