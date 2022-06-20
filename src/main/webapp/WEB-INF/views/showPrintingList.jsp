<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@include file="../layout/header.jsp" %>

        <div class="main pt-3">
          <div style="padding-top: 100px;"></div>
          <h1 class="text-center text-white">ລາຍການຂໍພິມບັດຈາກກະຊວງເລກທີ: ${doc_number}</h1>
          <div class="pt-5"></div>
          <div class="container-fluid">
          <div class="row">
          	<div class="col-md-12 mb-3">
          		<a href="${pageContext.request.contextPath}/verify_print_data/${doc_id}" class="btn btn-success btn-lg">Verify Data</a>
          	</div>
          </div>
            <table class="table table-hover bg-white table-border">
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
                	<tr class="align-middle">
                		<td>${(loop.index)+1}</td>
                		<th><img src="${print.photo}" style="width: auto; height: 100px;"></th>
                		<td><fmt:formatDate pattern="dd-MM-yyyy" value="${print.issue_date }" /></td>
                		<td>${print.issue_by }</td>
                		<td>${print.account_name }</td>
                		<td>${print.account_number}</td>
                		<td>${print.atm_number }</td>
                		<td>${print.note}</td>
                		<td>
                			<c:if test="${print.print_status == NULL}">
                				Not Completed
                			</c:if>
                		</td>
                	</tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>



        <%@include file="../layout/footer.jsp" %>
        <%@include file="../layout/toastrMessage.jsp" %>