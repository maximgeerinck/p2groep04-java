<%-- 
    Document   : listGuestRequests
    Created on : 5-mei-2014, 19:07:21
    Author     : Samsung
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Reservations</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="span8 offset2">
                    <p>Uw reservatie werd succesvol toegevoegd aan de lijst van reservaties</p>
                    <c:if test="${!empty guestRequests}">
                        <h3>Reservations</h3>
                        <table class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${guestRequests}" var="guestRequest">
                                <tr>
                                    <td>${guestRequest.getUser().lastName}, ${guestRequest.getUser().firstName}</td>
                                    <td>${guestRequest.getUser().email}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
