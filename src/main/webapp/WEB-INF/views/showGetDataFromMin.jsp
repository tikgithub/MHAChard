<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="main text-white">
    <div style="padding-top: 100px;"></div>
    <h2 class="text-center pt-3">
        <u>ດຶງຂໍ້ມູນຈາກກະຊວງ</u>
    </h2>
   <div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4 offset-md-4 text-center">
                <form action="${pageContext.request.contextPath}/send_request_api_data" method="get" class="pt-3">
                    <input required type="text" name="docnumber" id="docnumber" class="text-center form-control form-control-lg" placeholder="ເລກທີ່ເອກະສານ" value="${docnumber}">
                        <button type="submit" class="mt-3 btn btn-lg btn-primary shadow">
                            <i class="me-2 fas fa-server"></i>ຕົກລົງ</button>
                    </form>
                </div>
        </div>
    </div>
   </div>
        <div class="container pt-4 mb-5">
            <h3 class="mb-3">ເລກທີເອກະສານ: ${docnumber}, ວັນທີເອກະສານ: ${doc_date} (${persons.size()} ລາຍການ)</h3>
            <table class="table table-hover">
                <thead class="text-white bg-primary">
                    <tr>
                        <td>#</td>
                        <td>ຮູບພາບ</td>
                        <td>ຊື່ ແລະ ນາມສະກຸນ</td>
                        <td>ເພດ</td>
                        <td>ຊື່ ແລະ ນາມສະກຸນ(ພາສາອັງກິດ)</td>
                        <td>ວັນເດືອນປີເກີດ</td>
                        <td>ຊື່ບັນຊີ</td>
                        <td>ເລກບັນຊີ</td>
                    </tr>
                </thead>
                <tbody class="text-white">
                    <c:forEach var="person" items="${persons}" varStatus="loop">
                        <tr class="align-middle" style="cursor: pointer;">
                            <td>${(loop.index) + 1}</td>
                            <td>
                                <img src="${person.photo}" class="photo-list"></td>
                                <td>
                                    ${person.laFName} ${person.laLName}
                                </td>
                                <td>${person.sex}</td>
                                <td>
                                    ${person.enFName} ${person.enLName}
                                </td>
                                <td>
                                    ${person.DOB}
                                </td>
                                <td>${person.account_name}</td>
                                <td>${person.account_number}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <c:if test="${persons == null}">
                    NULL DATA
                </c:if>

                <c:if test="${persons!=null}">
                    <div class="text-center">
                        <button type="button" data-bs-toggle="modal" data-bs-target="#confirmDialog" type="submit" class="btn shadow btn-success btn-lg">
                            <i class="fas fa-save me-2"></i>ບັນທຶກເປັນລາຍການພິມບັດ</button>
                    </div>
                </c:if>
            </div>

           
        </div>
        <div class="modal fade" id="confirmDialog" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">ຢືຢັນ</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body text-center">
                        <div class="fs-4">ທ່ານຕ້ອງການບັນທຶກລາຍການນີ້ລົງໃນຖານຂໍ້ມູນພິມບັດແມ່ນບໍ່ ?</div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">ອອກ</button>
                        <a href="${pageContext.request.contextPath}/storeCardPrintData/${docnumber}" class="btn btn-success">ຕົກລົງ</a>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../layout/footer.jsp"%>
        <style>
            .photo-list {
                width: auto;
                height: 50px;
                border-radius: 10%;
            }
        </style>
