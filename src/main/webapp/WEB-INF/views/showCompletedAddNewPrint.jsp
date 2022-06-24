<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="main">
    <div class="pt-5"></div>
    <h1 class="pt-5 text-center" style="padding-top: 50px;">ດຳເນີນການສຳເລັດ</h1>
    <div class="text-center">

        <div class="trigger"></div>
        <div class="pt-3" style="width: 300px; height:200px; margin: auto;">
            <div class="wrapper">
                <svg class="checkmark" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 52 52">
                    <circle class="checkmark__circle" cx="26" cy="26" r="25" fill="none"/>
                    <path class="checkmark__check" fill="none" d="M14.1 27.2l7.1 7.2 16.7-16.8"/>
                </svg>
            </div>
        </div>
        <div class="text-center" style="padding-top: 80px;">
            <a href="${pageContext.request.contextPath}/getCardDataByDocNumber" class="btn btn-lg btn-primary">ກັບຄືນ</a>
        </div>
    </div>

</div>


<%@include file="../layout/footer.jsp"%>

<style>

    .checkmark__circle {
        stroke-dasharray: 166;
        stroke-dashoffset: 166;
        stroke-width: 2;
        stroke-miterlimit: 10;
        stroke: #7ac142;
        fill: none;
        animation: stroke 0.6s cubic-bezier(0.65, 0, 0.45, 1) forwards
    }
    .checkmark {
        width: 200px;
        height: 200px;
        border-radius: 50%;
        display: block;
        stroke-width: 4;
        stroke: #fff;
        stroke-miterlimit: 10;
        margin: 10% auto;
        box-shadow: inset 0 0 0 #7ac142;
        animation: fill 0.4s ease-in-out 0.4s forwards, scale 0.3s ease-in-out 0.9s both
    }
    .checkmark__check {
        transform-origin: 50% 50%;
        stroke-dasharray: 48;
        stroke-dashoffset: 48;
        animation: stroke 0.3s cubic-bezier(0.65, 0, 0.45, 1) 0.8s forwards
    }
    @keyframes stroke {
        100% {
            stroke-dashoffset: 0
        }
    }
   
    @keyframes fill {
        100% {
            box-shadow: inset 0 0 0 100px #7ac142
        }
    }
</style>
<script>
    document.onload = function () {

        $(".trigger").toggleClass("trigger")
    }
</script>
