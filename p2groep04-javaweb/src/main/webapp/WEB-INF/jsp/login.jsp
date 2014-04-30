<%-- 
    Document   : login
    Created on : 30-apr-2014, 17:28:40
    Author     : Bram
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

    </head>

    <body onload='document.f.j_username.focus();'>
        <div id="container-login" class="absolute-center">
            <form action="<c:url value='j_spring_security_check'/>" method='POST'>
                <table>
                    <tr>
                    <td>User:</td>
                    <td>
                        <input type='text' name='j_username' value=''/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type='password' name='j_password' />
                    </td>
                </tr>
                <tr>
                    <td colspan='2'><input name="submit" type="submit"
                                           value="Login" />
                    </td>
                </tr>
                </table>
            </form>
        </div>
    </body>

</html>
