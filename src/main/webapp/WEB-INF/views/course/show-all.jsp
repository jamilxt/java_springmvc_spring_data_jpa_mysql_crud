<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/course/add"
           class="btn btn-primary float-right">Add Course</a>
    </h3>

    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses }" var="course">
            <tr>
                <th>${ course.courseId }</th>
                <th>${ course.courseName }</th>
                <th><a href="edit?courseId=${ course.courseId }"
                       class="btn btn-success">Edit</a> <a href="delete?courseId=${ course.courseId }"
                                                           class="btn btn-danger ml-3">Delete</a></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>