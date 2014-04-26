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
        <script src='<c:url value="/resources/lib/moment.min.js"/>'></script>
        <script src='<c:url value="/resources/lib/jquery.min.js"/>'></script>
        <script src='<c:url value="/resources/lib/jquery-ui.custom.min.js"/>'></script>
        <script src='<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.js"/>'></script>
        
        <script>

	$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			defaultDate: '2014-01-12',
			editable: true,
			events: [
				{
					title: 'All Day Event',
					start: '2014-01-01'
				},
				{
					title: 'Long Event',
					start: '2014-01-07',
					end: '2014-01-10'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-01-09T16:00:00'
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: '2014-01-16T16:00:00'
				},
				{
					title: 'Meeting',
					start: '2014-01-12T10:30:00',
					end: '2014-01-12T12:30:00'
				},
				{
					title: 'Lunch',
					start: '2014-01-12T12:00:00'
				},
				{
					title: 'Birthday Party',
					start: '2014-01-13T07:00:00'
				},
				{
					title: 'Click for Google',
					url: 'http://google.com/',
					start: '2014-01-28'
				}
			]
		});
		
	});

</script>
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
