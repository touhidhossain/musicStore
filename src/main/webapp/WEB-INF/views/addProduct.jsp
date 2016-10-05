<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Add new product now!</p>
        </div>
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Name</label><form:errors path="productName" cssStyle="color: red;" />
                <form:input path="productName" class="form-control" id="name" placeholder="Product Name"/>
            </div>
            <div class="form-group">
                <label for="productCategory">Product Category</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" value="Instrument"/>Instrument</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" value="Record"/>Record</label>
                <label class="checkbox-inline"><form:radiobutton path="productCategory" id="productCategory" value="Accessory"/>Accessory</label>
            </div>
            <div class="form-group">
                <label for="productDescription">Product Description</label>
                <form:textarea path="productDescription" class="form-control" id="productDescription" placeholder="Product Description"/>
            </div>
            <div class="form-group">
                <label for="productPrice">Product Price</label><form:errors path="productPrice" cssStyle="color: red;" />
                <form:input path="productPrice" class="form-control" id="productPrice" placeholder=""/>
            </div>
            <div class="form-group">
                <label for="productCondition">Product Condition</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="productCondition" value="New"/>New</label>
                <label class="checkbox-inline"><form:radiobutton path="productCondition" id="productCondition" value="Used"/>Used</label>
            </div>
            <div class="form-group">
                <label for="productStatus">Product Status</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="productStatus" value="Active"/>Active</label>
                <label class="checkbox-inline"><form:radiobutton path="productStatus" id="productStatus" value="Inactive"/>Inactive</label>
            </div>
            <div class="form-group">
                <label for="unitInStock">Unit In Stock</label><form:errors path="unitInStock" cssStyle="color: red;" />
                <form:input path="unitInStock" class="form-control" id="unitInStock" placeholder=""/>
            </div>
            <div class="form-group">
                <label for="productManufacture">Product Manufacture</label>
                <form:input path="productManufacture" class="form-control" id="productManufacture" placeholder="Product Manufacture"/>
            </div>
            <div class="form-group">
                <label for="productImage">Upload Picture</label>
                <form:input type="file" id="productImage" path="productImage" class="form:input-large"/>
                <p class="help-block">Example block-level help text here.</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Check me out
                </label>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
            <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
        </form:form>
        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>
