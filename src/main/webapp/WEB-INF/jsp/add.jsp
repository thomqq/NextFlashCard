<%-- 
    Document   : add
    Created on : 2020-01-10, 11:12:08
    Author     : tkudas
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add FlashCard</title>
    </head>
    <body>
        <form>
            <table
                <tr><td>Question: </td><td><input type="text" name="question"></td></tr>
                <tr><td>Answer: </td><td><input type="text" name="answer"></td></tr>
                <tr><td>Question: </td><td><input type="text" name="question"></td></tr>
                <tr><td>Category: </td>
                    <td><select name="category">
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.id}">${cat.value}</option>
                            </c:forEach>
                        </select>
                    </td></tr>
                <tr><td>Part Of Speech: </td>
                    <td><select name="psrt_of_speech">
                            <c:forEach items="${psrt_of_speechies}" var="speech">
                                <option value="${speech.id}">${speech.value}</option>
                            </c:forEach>
                        </select>
                    </td></tr> 
            </table>
        </form>
    </body>
</html>
