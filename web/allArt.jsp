<%-- 
    Document   : allArt
    Created on : Apr 7, 2025, 1:36:18 PM
    Author     : antho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<c:forEach items='${allArt}' var='piece'>
	    <form action="Public" method="post">
		<input type="hidden" name="action" value="goToPiece">
		<input type="hidden" name="PieceID" value="${piece.piece_id}"/>
		<input type="submit" value="${piece.name}"/>
	    </form>
	</c:forEach>
	
	<form action="Public" method="post">
		<input type="hidden" name="action" value="toSecretPage">
		<input type="hidden" name="PieceID" value="${allArt["0"].piece_id}"/>
		<input type="hidden" name="auth" value="1234">
		<input type="submit" value="${allArt["0"].name} Secret"/>
	</form>
	
	<form action="Public" method="post">
		<input type="hidden" name="action" value="toSecretPage">
		<input type="hidden" name="PieceID" value="${allArt["0"].piece_id}"/>
		<input type="hidden" name="auth" value="0000">
		<input type="submit" value="${allArt["0"].name} Secret Fail"/>
	</form>
    </body>
</html>
