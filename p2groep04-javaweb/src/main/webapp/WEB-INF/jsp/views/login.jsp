<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="container-login" class="absolute-center">
    <h2>Login</h2>

    <c:if test="${not empty error}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>

    <form action="<c:url value='j_spring_security_check' />" method='POST'>

        <div class="form-group">
            <label for="username">Username:</label>
            <input type='text' class="form-control" name='j_username' value='' id="username"/>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type='password' class="form-control" name='j_password' value='' id="password"/>
        </div>

        <div class="form-group">
            <div class="checkbox">
                <label for="remember-me">Remember me</label>
                <input type="checkbox" class="form-control" id="remember-me" name="remember-me"/>
            </div>
        </div>

        <div class="form-group">
            <input name="submit" class="button" type="submit" value="Log in" />
        </div>
    </form>

    <script>
        $(window).resize(function() {

            $('.absolute-center').css({
                position: 'absolute',
                left: '50%',
                top: '50%',
                'margin-left': -$('#container-login').width() / 2,
                'margin-top': -$('#container-login').height() / 1.2


            });
        });
        // To initially run the function:
        $(window).resize();
    </script>
</div>