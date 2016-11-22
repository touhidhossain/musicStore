<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>
            <p class="lead">Customer Details.</p>
        </div>
        <form:form commandName="order" class="form-horizontal">

            <h1>Basic Info</h1>

            <div class="form-group">
                <label for="customerName">Name</label><form:errors path="cart.customer.customerName" cssStyle="color: red;" />
                <form:input path="cart.customer.customerName" class="form-control" id="customerName" placeholder="Name"/>
            </div>

            <div class="form-group">
                <label for="customerEmail">Email</label><form:errors path="cart.customer.customerEmail" cssStyle="color: red;" />
                <form:input path="cart.customer.customerEmail" class="form-control" id="customerEmail" placeholder="example@example.com"/>
            </div>

            <div class="form-group">
                <label for="customerPhone">Phone No</label><form:errors path="cart.customer.customerPhone" cssStyle="color: red;" />
                <form:input path="cart.customer.customerPhone" class="form-control" id="customerPhone" placeholder="+8801000000000"/>
            </div>

            <h1>Billing Address</h1>

            <div class="form-group">
                <label for="billingStreetName">Street Name</label><form:errors path="cart.customer.billingAddress.streetName" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.streetName" class="form-control" id="billingStreetName" placeholder="Street Name"/>
            </div>


            <div class="form-group">
                <label for="billingApartmentNumber">Appartment Number</label><form:errors path="cart.customer.billingAddress.apartmentNumber" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.apartmentNumber" class="form-control" id="billingApartmentNumber" placeholder="Apartment Number"/>
            </div>

            <div class="form-group">
                <label for="billingCity">City</label><form:errors path="cart.customer.billingAddress.city" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.city" class="form-control" id="billingCity" placeholder="City"/>
            </div>

            <div class="form-group">
                <label for="billingState">State</label><form:errors path="cart.customer.billingAddress.state" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.state" class="form-control" id="billingState" placeholder="State"/>
            </div>

            <div class="form-group">
                <label for="billingCountry">Country</label><form:errors path="cart.customer.billingAddress.country" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.country" class="form-control" id="billingCountry" placeholder="Country"/>
            </div>

            <div class="form-group">
                <label for="billingZipCode">Zip Code</label><form:errors path="cart.customer.billingAddress.zipCode" cssStyle="color: red;" />
                <form:input path="cart.customer.billingAddress.zipCode" class="form-control" id="billingZipCode" placeholder="Zip Code"/>
            </div>

            <input type="hidden" name="_flowExecutionKey" />

            <br><br>

            <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>

