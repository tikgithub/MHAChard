<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <c:if test="${flashError!=null}">
        <script>
            toastr.error("${flashError}")
        </script>
    </c:if>
    <c:if test="${warning!=null}">
        <script>
            toastr.warning("${warning}")
        </script>
    </c:if>
 <c:if test="${success!=null}">
        <script>
            toastr.success("${success}")
        </script>
    </c:if>