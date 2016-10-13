<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Product</h1>
            <p class="lead">Checkout All the awesome product Available now!</p>
        </div>
        <table CLASS="table table-striped table-hover">

            <thead>
            <tr class="bg-success">
                <th>Product Image</th>
                <th>Product Name</th>
                <th>Product Category</th>
                <th>Product Description</th>
                <th>Product Price</th>
                <th>Product Condition</th>
                <th>Product Status</th>
                <th>Product InStack</th>
                <th>Product Manufacture</th>
                <th>Info</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="/resources/images/${product.productId}.png" alt="image" style="width: 100%" /></td>
                    <td class="active">${product.productName}</td>
                    <td class="success">${product.productCategory}</td>
                    <td class="warning">${product.productDescription}</td>
                    <td class="info">${product.productPrice} BDT</td>
                    <td class="danger">${product.productCondition}</td>
                    <td class="active">${product.productStatus}</td>
                    <td class="success">${product.unitInStock}</td>
                    <td class="warning">${product.productManufacture}</td>
                    <td class="active"><a href="<spring:url value="/productList/viewProduct/${product.productId}"/>"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>

                </tr>
            </c:forEach>

        </table>
    <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>
