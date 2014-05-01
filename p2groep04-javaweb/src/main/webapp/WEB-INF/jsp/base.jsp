<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P2Groep4</title>
        
        <link href='<c:url value="/resources/plugins/fullcalendar/fullcalendar.css"/>' rel='stylesheet' />
        <link href='<c:url value="/resources/plugins/fullcalendar/fullcalendar.print.css"/>' rel='stylesheet' media='print' />
        
        <!-- project css -->
        <link href='<c:url value="/resources/css/style.css"/>' rel='stylesheet' media='print' />
        
        <script src='<c:url value="/resources/lib/moment.min.js"/>'></script>
        <script src='<c:url value="/resources/lib/jquery.min.js"/>'></script>
        <script src='<c:url value="/resources/lib/jquery-ui.custom.min.js"/>'></script>
        <script src='<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.js"/>'></script>
        
        
<style>

	body {
		margin: 0;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		width: 900px;
		margin: 40px auto;
	}

</style>
    </head>
        
    <body>

        <tiles:insertAttribute name="body"/>
    </body>
</html>
