<%--
  Created by IntelliJ IDEA.
  User: TOUHID
  Date: 9/17/2016
  Time: 10:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/templete/header.jsp"%>
<div id="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administator Page</h1>
            <p class="lead">This is administator page!</p>
        </div>
        <h2>Welcome Admin | <a href="<c:url value="/logout"/>">Logout</a> </h2>
        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>
        <p>Here you can view, modify & check product inventory.</p>

        <%@include file="/WEB-INF/views/templete/footer.jsp"%>
    </div>

</div>
</html>