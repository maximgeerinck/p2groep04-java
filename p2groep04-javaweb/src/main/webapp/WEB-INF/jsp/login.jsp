<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <body onload='document.loginForm.j_username.focus();'>
        <h3>I'm different :C</h3>

        <c:if test="${not empty error}">
            <div class="errorblock">
                Your login attempt was not successful, try again.<br /> Caused :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
            <table>
                <tr>
                    <td>User:</td>
                    <td>
                        <input type='text' name='username' value=''/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type='password' name='password' />
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <input name="submit" type="submit" value="Login" />
                    </td>
                </tr>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            </table>
        </form>

    </div>
</body>

</html>
