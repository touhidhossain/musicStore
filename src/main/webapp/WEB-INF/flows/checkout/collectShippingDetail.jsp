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

            <h1>Shipping Address</h1>

            <div class="form-group">
                <label for="shippingStreetName">Street Name</label><form:errors path="cart.customer.shippingAddress.streetName" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.streetName" class="form-control" id="shippingStreetName" placeholder="Street Name"/>
            </div>


            <div class="form-group">
                <label for="shippingApartmentNumber">Appartment Number</label><form:errors path="cart.customer.shippingAddress.apartmentNumber" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.apartmentNumber" class="form-control" id="shippingApartmentNumber" placeholder="Apartment Number"/>
            </div>

            <div class="form-group">
                <label for="shippingCity">City</label><form:errors path="cart.customer.shippingAddress.city" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.city" class="form-control" id="shippingCity" placeholder="City"/>
            </div>

            <div class="form-group">
                <label for="shippingState">State</label><form:errors path="cart.customer.shippingAddress.state" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.state" class="form-control" id="shippingState" placeholder="State"/>
            </div>

            <div class="form-group">
                <label for="shippingCountry">Country</label><form:errors path="cart.customer.shippingAddress.country" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.country" class="form-control" id="shippingCountry" placeholder="Country"/>
            </div>

            <div class="form-group">
                <label for="shippingZipCode">Zip Code</label><form:errors path="cart.customer.shippingAddress.zipCode" cssStyle="color: red;" />
                <form:input path="cart.customer.shippingAddress.zipCode" class="form-control" id="shippingZipCode" placeholder="Zip Code"/>
            </div>

            <input type="hidden" name="_flowExecutionKey" />

            <br><br>

            <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
            <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />
            <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
        </form:form>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>

