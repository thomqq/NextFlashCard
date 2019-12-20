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
        <script src="https://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#answerButton").click(function () {
                    $("#answerButton").hide();
                    $("#answerText").show();
                    $("#thumbs").show();
                });
            });
        </script>
    </head>
    <body>
        <table class="mainTable" cellspacing="10">
            <tr with="300">
                <td>Pytanie: </td><td>${flash_card.question} </td>
            </tr>
            <tr with="300">
                <td>Odpowiedź: </td><td><button id="answerButton">ShowAnswer</button><span id="answerText" style="display: none"> ${flash_card.answer}</span></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div id="thumbs" style="display: none;">
                        <a href="<c:url value='show/incorrect'/>"><img src="<c:url value='/pictures/thumb-down.png'/>" style="width: auto; padding: 15px; text-decoration: none;"></a>
                        <a href="<c:url value='show/correct'/>"><img src="<c:url value='/pictures/thumb-up.png'/>" style="width: auto; padding: 15px; text-decoration: none;"></a>
                    </div>
                </td>
            </tr>
        </table>
    </body>
</html>
