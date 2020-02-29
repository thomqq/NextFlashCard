<%-- 
    Document   : newjsp
    Created on : 2020-02-22, 11:23:56
    Author     : tkudas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body onload='document.loginForm.username.focus();'>
	<c:if test="${not empty error}"><div>${error}</div></c:if>
	<c:if test="${not empty message}"><div>${message}</div></c:if>

	<form name='login' action="<c:url value='/logic/loginPage' />" method='POST'>
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
