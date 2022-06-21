<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../layout/header.jsp"%>

<div class="main">
	<div style="padding-top: 80px;"></div>
	<h3 class="text-center">ລາຍການຂໍພິມບັດຈາກກະຊວງເລກທີ:
		${doc_number}</h3>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12 text-center mb-3">
				<a
					href="${pageContext.request.contextPath}/verify_print_data/${doc_id}"
					class="btn btn-success me-3"><i class="fas fa-sync me-2"></i>ກວດສອບຂໍ້ມູນ</a> 
			   <a
					href="${pageContext.request.contextPath}/verify_print_data/${doc_id}"
					class="btn btn-warning"><i class="fas fa-check-double me-2"></i>ສຳເລັດການອອກບັດ</a>
			</div>
		</div>
		<table class="table table-hover bg-white table-border" id="person">
			<thead>
				<tr class="">
					<th>#</th>
					<th>Photo</th>
					<th>ອອກວັນທີ</th>
					<th>ອອກໂດຍ</th>
					<th>ຊີ່ບັນຊີ</th>
					<th>ເລກບັນຊີ</th>
					<th>ເລກບັດ</th>
					<th>ຈາກ</th>
					<th>ສະຖານະການພິມ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="print" items="${prints}" varStatus="loop">
					<tr onclick="showEditPage(`${print.id}`)" class="align-middle" style="cursor: pointer;">
						<td>${(loop.index)+1}</td>
						<th><img src="${print.photo}"
							style="width: auto; height: 60px;"></th>
						<td><fmt:formatDate pattern="dd-MM-yyyy"
								value="${print.issue_date }" /></td>
						<td>${print.issue_by }</td>
						<td>${print.account_name }</td>
						<td>${print.account_number}</td>
						<td>${print.atm_number }</td>
						<td>${print.note}</td>
						<td>
							<c:if test="${print.print_status == 'GENERATED_FIALED'}">
								<span class="badge bg-danger blink_me">${print.print_status }</span>
							</c:if> 
							
							<c:if test="${print.print_status=='GENERATED_OK' }">
								<span class="badge bg-success">${print.print_status}</span>
							</c:if>
							
							<c:if test="${print.print_status == null}">
								<span class="badge bg-secondary">No Status</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Modal -->
	</div>

	<%@include file="../layout/footer.jsp"%>
	<%@include file="../layout/toastrMessage.jsp"%>
	<script type="text/javascript">
		function showEditPage(id){
			let url = (window.location.origin + "/showEditPage/" + id);
			window.location.href = url;
		}
	</script>