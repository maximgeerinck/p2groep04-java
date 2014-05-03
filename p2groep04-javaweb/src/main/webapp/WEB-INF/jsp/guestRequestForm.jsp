<%-- 
    Document   : guestRequest
    Created on : 3-mei-2014, 11:50:01
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="" method='POST'>
            <table>
                <tr>
                    <td>Naam:</td>
                    <td>
                        <input type='text' name='name'/>
                    </td>
                </tr>
                <tr>
                    <td>Voornaam:</td>
                    <td>
                        <input type='text' name='firstname' />
                    </td>
                </tr>
                <tr>
                    <td colspan='2'>
                        <input name="submit" type="submit" value="Inschrijven" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
