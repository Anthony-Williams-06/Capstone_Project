<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/individualArt.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="container">
            <div class="form-container">
                <h1>Add New Piece</h1>
                <form action="Private?action=addPageSubmit" method="post" enctype="multipart/form-data">
		    <div class="form-group">
                        <label for="piecePhoto">Piece Cover Photo:</label>
                        <input type="file" id="piecePhoto" name="piecePhoto" class="form-control photo" accept="image/*">
                    </div>

                    <div class="form-group">
                        <label for="pieceName">Piece Name:</label>
                        <input type="text" id="pieceName" name="pieceName" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label for="piecePrice">Piece Price:</label>
                        <input type="number" id="piecePrice" name="piecePrice" class="form-control" step="0.01" required>
                    </div>

                    <div class="form-group">
                        <label for="pieceSize">Piece Size:</label>
                        <input type="text" id="pieceSize" name="pieceSize" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label for="pieceMedium">Piece Medium:</label>
                        <input type="text" id="pieceMedium" name="pieceMedium" class="form-control" required>
                    </div>

                    <div class="form-group">
                        <label for="photo1">Photo 1:</label>
                        <input type="file" id="photo1" name="photo1" class="form-control photo" accept="image/*">
                    </div>

                    <div class="form-group">
                        <label for="textBox1">Text Box 1:</label>
                        <textarea id="textBox1" name="textBox1" class="form-control textBox"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="photo2">Photo 2:</label>
                        <input type="file" id="photo2" name="photo2" class="form-control photo" accept="image/*">
                    </div>

                    <div class="form-group">
                        <label for="textBox2">Text Box 2:</label>
                        <textarea id="textBox2" name="textBox2" class="form-control textBox"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="photo3">Photo 3:</label>
                        <input type="file" id="photo3" name="photo3" class="form-control photo" accept="image/*">
                    </div>

                    <div class="form-group">
                        <label for="textBox3">Text Box 3:</label>
                        <textarea id="textBox3" name="textBox3" class="form-control textBox"></textarea>
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Create</button>
                    </div>
                </form>
            </div>
	    <c:if test="${not empty key}">
		<div id="outputBox" class="alert alert-info mt-4">
		    <p>${key}</p>
		</div>
	    </c:if>
        </div>
    </body>
</html>