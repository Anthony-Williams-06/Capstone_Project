<%-- 
    Document   : secretPage
    Created on : Mar 27, 2025, 3:59:26 PM
    Author     : anthony williams
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Art Page</title>
    </head>
    <body>
	<c:url value="/images/${piece.cover_image}" var="imgPathCover"/>
	<img src="${imgPathCover}" alt="Test Image"/>
	<p>${piece.name}</p>
	<p>${piece.medium}</p>
	<p>${piece.price}</p>
	
        <p>${pageElements["1"].source}</p>
	
        <c:url value="/images/${pageElements['2'].source}" var="imgPath1"/>
	<p>${imgPath1}</p>
	<img src="${imgPath1}" alt="image slot 1"/>

	<c:url value="/images/${pageElements['3'].source}" var="imgPath2"/>
	<img src="${imgPath2}" alt="image slot 2"/>
	
        <p>${pageElements["4"].source}</p>
	
	<c:url value="/images/${pageElements['5'].source}" var="imgPath3"/>
	<img src="${imgPath3}" alt="image slot 3"/>
	
	
	<p>${pageElements["6"].source}</p>
	
        
    </body>
</html>
