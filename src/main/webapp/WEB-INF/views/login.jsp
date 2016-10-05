<%@include file="/WEB-INF/views/templete/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <div class="page-header">
                <h1>Login</h1>
                <p>Login with username and password.</p>
            </div>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>
            <form name="loginForm" action="<c:url value="/login"/>" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: red;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
                <input type="submit" class="btn btn-default" value="Submit">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
            <%@include file="/WEB-INF/views/templete/footer.jsp"%>
        </div>

    </div>


</div>
</html>