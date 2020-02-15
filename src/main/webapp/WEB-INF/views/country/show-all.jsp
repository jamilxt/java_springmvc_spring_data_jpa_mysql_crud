<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- HEADER -->
<jsp:include page="../common/header.jsp"/>

<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <h3 class="mt-3 mb-3">${ pageTitle }
        <a href="${pageContext.request.contextPath }/country/add"
           class="btn btn-primary float-right">Add Country</a>
    </h3>

    <table class="table table-bordered">
        <thead class="thead-light">
        <tr>
            <th>ID</th>
            <th>Country Code</th>
            <th>Country Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${countries }" var="country">
            <tr>
                <th>${ country.id }</th>
                <th>${ country.countryCode }</th>
                <th>${ country.countryName }</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


<!-- FOOTER -->
<jsp:include page="../common/footer.jsp"/>