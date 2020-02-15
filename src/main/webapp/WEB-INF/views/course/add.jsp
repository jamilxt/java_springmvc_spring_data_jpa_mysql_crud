<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/course/show-all"
           class="btn btn-primary float-right">Course List</a>
    </h3>

    <form:form action="${pageContext.request.contextPath }/course/add"
               modelAttribute="course">
        <div class="form-group">
            <label>Course Name</label>
            <form:input path="courseName" class="form-control"/>
        </div>
        <input type="submit" name="submit" value="Add"
               class="btn btn-primary btn-lg btn-block">
    </form:form>

</div>


<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>