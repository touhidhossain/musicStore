<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TOUHID
  Date: 7/11/2016
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div class="container-wrapper">
    <div class="container" >
        <div class="page-header">
            <h1>Product Details</h1>
            <p class="lead">Here is the details information of the product</p>

        </div>
        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="/resources/images/${product.productID}.png" alt="image" style="width: 100%" />

                </div>
                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productCategory}</p>
                    <p><strong>Description: ${product.productDescription}</strong> </p>
                    <p><strong>Condition: ${product.productCondition}</strong></p>
                    <p><strong>Status: ${product.productStatus}</strong></p>
                    <p><strong>InStock: ${product.unitInStock}</strong></p>
                    <p><strong>Manufacture: ${product.productManufacture}</strong></p>
                    <h4><strong>${product.productPrice} BDT</strong></h4>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}"></c:set>
                    <c:set var="url" scope="page" value="/productList"></c:set>
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory"></c:set>
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-group-lg" ng-click="addToCart('${product.productID}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                        <a href="<spring:url value="/cart"/>" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                    </p>
                </div>
            </div>
            <script src="<c:url value="/resources/js/controller.js"/>"></script>
            <%@include file="/WEB-INF/views/templete/footer.jsp"%>

        </div>

    </div>
</div>
</html>