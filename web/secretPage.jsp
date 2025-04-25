<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<% 
    if (request.getAttribute("validRequest") == null || !((boolean) request.getAttribute("validRequest"))) {
        response.sendRedirect("index.jsp"); // Redirect if the request is not valid
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/individualArt.css">
        <title>${piece.name} - Secret Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container mt-4">
            <div class="cover-section">
                <c:url value="/images/${piece.cover_image}" var="imgPathCover" />
                <img src="${imgPathCover}" alt="${piece.name} Cover Image" class="cover-image">
                <div class="cover-text">
                    <h2>${piece.name}</h2>
                    <p><span class="fw-bold">Medium:</span> ${piece.medium}</p>
                    <p><span class="fw-bold">Price:</span> ${piece.price}</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 row-element text-center">
                    <c:url value="/images/${pageElements['1'].source}" var="imgPath1" />
                    <img src="${imgPath1}" alt="Image Slot 1">
                </div>
                <div class="col-md-6 row-element">
                    <p class="art-text">${pageElements["2"].source}</p>
                </div>
            </div>

            <div class="row">
		<div class="col-md-6 row-element">
                    <p class="art-text">${pageElements["4"].source}</p>
                </div>
                <div class="col-md-6 row-element text-center">
                    <c:url value="/images/${pageElements['3'].source}" var="imgPath2" />
                    <img src="${imgPath2}" alt="Image Slot 2">
                </div>
            </div>

            <div class="row">
                <div class="col-md-6 row-element text-center">
                    <c:url value="/images/${pageElements['5'].source}" var="imgPath3" />
                    <img src="${imgPath3}" alt="Image Slot 3">
                </div>
                <div class="col-md-6 row-element">
                    <p class="art-text">${pageElements["6"].source}</p>
                </div>
            </div>
        </div>
    </body>
</html>