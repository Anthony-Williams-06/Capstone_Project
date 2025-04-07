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
		<input type="hidden" name="pageId" value="${piece.art_page_id}"/>
		<input type="submit" value="${piece.name}"/>
	    </form>
	</c:forEach>
    </body>
</html>
