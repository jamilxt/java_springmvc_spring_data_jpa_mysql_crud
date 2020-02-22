<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/student/show-all"
           class="btn btn-primary float-right">Student List</a>
    </h3>

    <form:form action="${pageContext.request.contextPath }/student/add"
               modelAttribute="student">
        <div class="form-group">
            <label>Name</label>
            <form:input path="name" class="form-control"></form:input>
        </div>
        <div class="form-group">
            <label>Age</label>
            <form:input path="age" class="form-control" type="number"></form:input>
        </div>

        <div class="form-check">
            <label>Gender</label><br>
            <form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
        </div>

        <div class="form-group">
            <label>Email</label>
            <form:input path="email" class="form-control"></form:input>
        </div>

        <div class="form-group">
            <label>Select a country</label>
            <form:select class="form-control" path="countryCode">
                <form:options items="${countries}" itemLabel="countryName"
                              itemValue="countryCode"></form:options>
            </form:select>
        </div>

        <div class="form-group">
            <label>Select a course</label>
            <form:select class="form-control" multiple="true" path="courseCodes">
                <form:options items="${courses}" itemLabel="courseName"
                              itemValue="courseCode"></form:options>
            </form:select>
        </div>


        <input type="submit" name="submit" value="Add"
               class="btn btn-primary btn-lg btn-block">
    </form:form>

</div>


<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>