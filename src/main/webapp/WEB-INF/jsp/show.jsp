<%-- 
    Document   : QAPage
    Created on : 2019-11-30, 09:23:45
    Author     : tkudas
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/EnglishFlashCard/main.css" />
        <title>FlasCard</title>
    </head>
    <body>
        <table class="mainTable">
            <tr with="300">
                <td>Pytanie: </td><td>${flash_card.question} </td>
            </tr>
            <c:set var="conditional" value="${showAnswer}"/>
            <form:form action="zosia" >
                <tr with="300">
                    <td>Odpowiedź: </td><td>
                        <c:choose>
                            <c:when test="${conditional.equals('true')}">
                                ${flash_card.answer}
                            </c:when>
                            <c:otherwise>
                                --------- <br>
                                <input type="submit" value="Answer"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </form:form>
        </table>
    </body>
</html>
