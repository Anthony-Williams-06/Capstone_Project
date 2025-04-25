<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/allArt.css">
        <title>Art Gallery</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        
        <div class="container mt-4">
            <div class="row">
                <c:forEach items="${allArt}" var="piece">
                    <div class="col-md-3 d-flex justify-content-center">
                        <form action="Public" method="post" class="card shadow-sm" style="text-decoration: none;">
                            <input type="hidden" name="action" value="goToPiece">
                            <input type="hidden" name="PieceID" value="${piece.piece_id}">
                            
                            <c:url value="/images/${piece.cover_image}" var="imgPath" />
                            <button type="submit" style="all: unset; width: 100%; height: 100%;">
                                <img src="${imgPath}" alt="Art Cover Image" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title text-center">${piece.name}</h5>
                                    <p class="card-text text-center">
                                        <span class="fw-bold">Price:</span> ${piece.price}<br>
                                        <span class="fw-bold">Size:</span> ${piece.size}
                                    </p>
                                </div>
                            </button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>