<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/user/show-all"
           class="btn btn-primary float-right">User List</a>
    </h3>

    <form:form action="${pageContext.request.contextPath }/user/add"
               modelAttribute="user">
        <div class="form-group">
            <label>Username</label>
            <form:input path="username" class="form-control" required="required"></form:input>
        </div>
        <div class="form-group">
            <label>Password</label>
            <form:input path="password" class="form-control" type="password" id="password"
                        required="required"></form:input>
        </div>

        <div class="form-group">
            <label>Confirm Password</label>
            <form:input path="" class="form-control" type="password" id="confirm_password"
                        required="required"></form:input>
        </div>

        <div class="form-check">
            <label>Role</label><br>
            <form:radiobuttons class="radio-inline" path="role" items="${ roles }"
                               required="required"></form:radiobuttons>
        </div>

        <h3 class="mt-3 mb-3">Personal Information</h3>
        <div class="form-group">
            <label>Full Name</label>
            <form:input path="fullName" class="form-control" required="required"></form:input>
        </div>

        <div class="form-check">
            <label>Gender</label><br>
            <form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
        </div>

        <div class="form-group">
            <label>Email</label>
            <form:input path="email" class="form-control" type="email" required="required"></form:input>
        </div>


        <div class="form-group">
            <label>Date of Birth</label>
            <input class="form-control" type="date" required="required" name="dob_f"/>
        </div>

        <input type="submit" name="submit" value="Add"
               class="btn btn-primary btn-lg btn-block">
    </form:form>

</div>

<script>
    var password = document.getElementById("password")
        , confirm_password = document.getElementById("confirm_password");

    function validatePassword() {
        if (password.value !== confirm_password.value) {
            confirm_password.setCustomValidity("Password doesn't match");
        } else {
            confirm_password.setCustomValidity('');
        }
    }

    password.onchange = validatePassword;
    confirm_password.onkeyup = validatePassword;
</script>


<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>