<%-- 
    Document   : newjspmain
    Created on : 26-Apr-2014, 19:34:11
    Author     : Maxim
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <div>Username: ${username}</div>
        <div>Message: ${message}</div>
        <a href="<c:url value='/j_spring_security_logout'/>" > Logout</a>
    </body>
</html>
