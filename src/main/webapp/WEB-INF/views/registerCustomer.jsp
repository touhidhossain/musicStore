<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register</h1>
            <p class="lead">Register as new customer.</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/register" method="post" commandName="customer">

            <h1>Basic Info</h1>

            <div class="form-group">
                <label for="customerName">Name</label><form:errors path="customerName" cssStyle="color: red;" />
                <form:input path="customerName" class="form-control" id="customerName" placeholder="Name"/>
            </div>

            <div class="form-group">
                <label for="customerEmail">Email</label><form:errors path="customerEmail" cssStyle="color: red;" /><span style="color: red">${emailMsg}</span>
                <form:input path="customerEmail" class="form-control" id="customerEmail" placeholder="example@example.com"/>
            </div>

            <div class="form-group">
                <label for="customerPhone">Phone No</label><form:errors path="customerPhone" cssStyle="color: red;" />
                <form:input path="customerPhone" class="form-control" id="customerPhone" placeholder="+8801000000000"/>
            </div>

            <div class="form-group">
                <label for="username">Username</label><form:errors path="username" cssStyle="color: red;" /><span style="color: red">${usernameMsg}</span>
                <form:input path="username" class="form-control" id="username" placeholder="username"/>
            </div>

            <div class="form-group">
                <label for="password">Password</label><form:errors path="password" cssStyle="color: red;" />
                <form:password path="password" class="form-control" id="password" placeholder="password"/>
            </div>


            <h1>Billing Address</h1>

            <div class="form-group">
                <label for="billingStreetName">Street Name</label><form:errors path="billingAddress.streetName" cssStyle="color: red;" />
                <form:input path="billingAddress.streetName" class="form-control" id="billingStreetName" placeholder="Street Name"/>
            </div>


            <div class="form-group">
                <label for="billingApartmentNumber">Appartment Number</label><form:errors path="billingAddress.apartmentNumber" cssStyle="color: red;" />
                <form:input path="billingAddress.apartmentNumber" class="form-control" id="billingApartmentNumber" placeholder="Apartment Number"/>
            </div>

            <div class="form-group">
                <label for="billingCity">City</label><form:errors path="billingAddress.city" cssStyle="color: red;" />
                <form:input path="billingAddress.city" class="form-control" id="billingCity" placeholder="City"/>
            </div>

            <div class="form-group">
                <label for="billingState">State</label><form:errors path="billingAddress.state" cssStyle="color: red;" />
                <form:input path="billingAddress.state" class="form-control" id="billingState" placeholder="State"/>
            </div>

            <div class="form-group">
                <label for="billingCountry">Country</label><form:errors path="billingAddress.country" cssStyle="color: red;" />
                <form:input path="billingAddress.country" class="form-control" id="billingCountry" placeholder="Country"/>
            </div>

            <div class="form-group">
                <label for="billingZipCode">Zip Code</label><form:errors path="billingAddress.zipCode" cssStyle="color: red;" />
                <form:input path="billingAddress.zipCode" class="form-control" id="billingZipCode" placeholder="Zip Code"/>
            </div>


            <h1>Shipping Address</h1>

            <div class="form-group">
                <label for="shippingStreetName">Street Name</label><form:errors path="shippingAddress.streetName" cssStyle="color: red;" />
                <form:input path="shippingAddress.streetName" class="form-control" id="shippingStreetName" placeholder="Street Name"/>
            </div>


            <div class="form-group">
                <label for="shippingApartmentNumber">Appartment Number</label><form:errors path="shippingAddress.apartmentNumber" cssStyle="color: red;" />
                <form:input path="shippingAddress.apartmentNumber" class="form-control" id="shippingApartmentNumber" placeholder="Apartment Number"/>
            </div>

            <div class="form-group">
                <label for="shippingCity">City</label><form:errors path="shippingAddress.city" cssStyle="color: red;" />
                <form:input path="shippingAddress.city" class="form-control" id="shippingCity" placeholder="City"/>
            </div>

            <div class="form-group">
                <label for="shippingState">State</label><form:errors path="shippingAddress.state" cssStyle="color: red;" />
                <form:input path="shippingAddress.state" class="form-control" id="shippingState" placeholder="State"/>
            </div>

            <div class="form-group">
                <label for="shippingCountry">Country</label><form:errors path="shippingAddress.country" cssStyle="color: red;" />
                <form:input path="shippingAddress.country" class="form-control" id="shippingCountry" placeholder="Country"/>
            </div>

            <div class="form-group">
                <label for="shippingZipCode">Zip Code</label><form:errors path="shippingAddress.zipCode" cssStyle="color: red;" />
                <form:input path="shippingAddress.zipCode" class="form-control" id="shippingZipCode" placeholder="Zip Code"/>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
            <a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
        </form:form>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>

