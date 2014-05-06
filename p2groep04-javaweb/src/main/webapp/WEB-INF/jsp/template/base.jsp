<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header>
    <div class="wrapper">
        <nav id="header-nav" class="clearfix">
            <ul id="main-nav">
                <li><a href="#">Dashboard</a></li>
            </ul>
            <div id="account-nav" class="dropdown">
                <a class="thumb-sm avatar" data-toggle="dropdown" href="#">
                    <img src="https://chamilo.hogent.be/application/bamaflex/php/webservices/foto_call.class.php?user_id=1" /><security:authentication property="principal.username"/><span class="caret"></span>
                </a>

                <ul class="dropdown-menu animated fadeInRight" role="menu" aria-labelledby="dLabel">
                    <li><a href="#">Change password</a></li>
                    <li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
                </ul>
            </div>
        </nav>

    </div>
</header>

<div id="content" class="wrapper">
    <tiles:insertAttribute name="body"/> 
</div>

<div style="clear:both;"></div>
