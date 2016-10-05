<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory</h1>
            <p class="lead">Checkout All the product Available now!</p>
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
                <th>Info, Edit, Remove</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="/resources/images/${product.productID}.png" alt="image" style="width: 100%" /></td>
                    <td class="active">${product.productName}</td>
                    <td class="success">${product.productCategory}</td>
                    <td class="warning">${product.productDescription}</td>
                    <td class="info">${product.productPrice} BDT</td>
                    <td class="danger">${product.productCondition}</td>
                    <td class="active">${product.productStatus}</td>
                    <td class="success">${product.unitInStock}</td>
                    <td class="warning">${product.productManufacture}</td>
                    <td class="active"><a href="<spring:url value="/productList/viewProduct/${product.productID}"/>"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                    <a href="<spring:url value="/admin/productInventory/editProduct/${product.productID}"/>"
                    ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productID}"/>"
                    ><span class="glyphicon glyphicon-remove"></span></a></td>

                </tr>
            </c:forEach>

        </table>
        <a href="<spring:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary">Add Product</a>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>
