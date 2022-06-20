<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
      <%@include file="../layout/header.jsp" %>

        <div class="main pt-3">
          <div style="padding-top: 100px;"></div>
          <h1 class="text-center text-white">ລາຍການຂໍພິມບັດຈາກກະຊວງ</h1>
          <div class="pt-5"></div>
          <div class="container">
            <table class="table table-hover bg-white table-border">
              <thead>
                <tr class="">
                  <th>#</th>
                  <th>ເລກທີເອກະສານ</th>
                  <th>ວັນທີ່ເອກະສານ</th>
                  <th>ວັນທີ່ເພີ່ມເຂົ້າລະບົບ</th>
                  <th>ການພິມ</th>
                  <th>ສະຖານະການພິມ</th>
                  <th><i class="fas fa-cog"></i></th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="doc" items="${docs}" varStatus="loop">
                  <tr class="align-middle">
                    <td>${(loop.index) + 1}</td>
                    <td>${doc.docNumber}</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${doc.docDate}" /></td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${doc.addDate}"/></td>
                    <td>${doc.addBy}</td>
                    <td>
                      <span class="badge bg-warning text-dark">${doc.printStatus}</span>
                    </td>
                    <td>
                      <a href="${pageContext.request.contextPath}/printing_list/${doc.id}" class="btn btn-warning"><i class="fas fa-arrow-alt-circle-right"></i></a>
                    </td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>



        <%@include file="../layout/footer.jsp" %>