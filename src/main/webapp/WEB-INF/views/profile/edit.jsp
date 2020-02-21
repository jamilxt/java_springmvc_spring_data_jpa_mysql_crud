<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }</h3>

    <form:form action="${pageContext.request.contextPath }/change_password" method="POST">
        <%--        <div class="form-group">--%>
        <%--            <label>Old Password</label>--%>
        <%--            <form:input path="password" class="form-control" type="password"></form:input>--%>
        <%--        </div>--%>
        <%--        <div class="form-group">--%>
        <%--            <label>New Password</label>--%>
        <%--            <form:input path="new_password" class="form-control" type="password"></form:input>--%>
        <%--        </div>--%>
        <%--        <div class="form-group">--%>
        <%--            <label>New Password</label>--%>
        <%--            <form:input path="retype_new_password" class="form-control" type="password"></form:input>--%>
        <%--        </div>--%>

        <input type="submit" name="submit" value="Change Password"
               class="btn btn-primary btn-lg btn-block">
    </form:form>

</div>

<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>