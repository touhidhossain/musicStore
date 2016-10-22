<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templete/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer Registration Successful.</h1>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Products</a>
            </p>
        </section>
        <%@include file="/WEB-INF/views/templete/footer.jsp" %>
    </div>
</div>
</html>