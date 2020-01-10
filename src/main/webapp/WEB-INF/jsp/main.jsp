<%-- 
    Document   : main
    Created on : 2019-12-20, 11:23:12
    Author     : tkudas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main</title>
    </head>
    <body>
        <table height ="100" widht = "200" cellspacing="10">
            <tr>
                <td><button onclick="location.href='add'">Create FlashCard</button></td>
                <td><button onclick="location.href='show'">Start Lesson</button></td>
                <!--
                <td><button onclick="location.href='<c:url value='show'/>'">Start Lesson</button></td>
                -->
            </tr>
        </table>            
    </body>
</html>
