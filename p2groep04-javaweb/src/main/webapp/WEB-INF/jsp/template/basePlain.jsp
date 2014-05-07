<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <spring:url value="/resources/css/style.css" var="style"/>
        <spring:url value="/resources/css/pluginOverrides.css" var="css_pluginOverrides"/>
        <spring:url value="/resources/plugins/animate/css/animate.css" var="css_animate"/>
        <spring:url value="/resources/plugins/mono-social-icons/css/MonoSocialIconsFont.css" var="css_socialIcons"/>
        
        <spring:url value="/resources/plugins/fullcalendar/fullcalendar.css" var="css_fullcalendar"/>
        <spring:url value="/resources/plugins/fullcalendar/fullcalendar.print.css" var="css_fullcalendarprint"/>
        
        <spring:url value="/resources/plugins/bootstrap-modified/css/bootstrap.css" var="css_bootstrap"/>
        <spring:url value="/resources/plugins/bootstrap-modified/css/bootstrap-theme.css" var="css_bootstraptheme"/>
        <spring:url value="/resources/plugins/bootstrap/js/bootstrap.js" var="js_bootstrap"/>
        
        <c:set var="css_version" value="1.0" />
        <c:set var="js_version" value="1.0" />
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>P02Groep04</title>
        
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
         
        
        <link rel="stylesheet" href="${css_fullcalendar}" type="text/css" /> 
        <link rel="stylesheet" href="${css_fullcalendarprint}" type="text/css" media="print"/> 
        
        <link rel="stylesheet" href="${css_bootstrap}" type="text/css" /> 
        <link rel="stylesheet" href="${css_bootstraptheme}" type="text/css" /> 
        
        <link rel="stylesheet" href="${css_animate}" type="text/css" /> 
        
        <!-- project css -->
        <link rel="stylesheet" href="${style}" type="text/css" /> 
        <link rel="stylesheet" href="${css_socialIcons}" type="text/css" /> 
        <link rel="stylesheet" href="${css_pluginOverrides}" type="text/css" /> 
        
        <script src="<c:url value="/resources/lib/moment.min.js"/>"></script>
        <script src="<c:url value="/resources/lib/jquery.min.js"/>"></script>
        <script src="<c:url value="/resources/lib/jquery-ui.custom.min.js"/>"></script>
        <script src="<c:url value="/resources/plugins/fullcalendar/fullcalendar.min.js"/>"></script>
        <script src="${js_bootstrap}"></script>

    </head>
        
    <body>

        <div id="wrapper">
           <tiles:insertAttribute name="main"/> 
           <tiles:insertAttribute name="footer"/>
        </div>  
        
        <script>
            $('.errorblock, .field-validation-error, .alert').each(function() {
                $(this).addClass('animated fadeInDown');
            });     
        </script>
    </body>
</html>
