<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/student/add"
           class="btn btn-primary float-right">Add Student</a>
    </h3>

    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Email</th>
            <th>Courses</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ students }" var="student">
        <tr>
            <th>${ student.id }</th>
            <th>${ student.name }</th>
            <th>${ student.gender }</th>
            <th>${ student.age }</th>
            <th>${ student.email }</th>
            <th>
                <c:forEach items="${student.courses}" var="course">
                    <div>${course.courseName}</div>
                </c:forEach>
            </th>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>