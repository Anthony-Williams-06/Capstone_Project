<%-- 
    Document   : index
    Created on : Mar 24, 2025, 12:34:06 PM
    Author     : anthony williams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Envision Galleries</title>
    </head>
    <body>
        <p>Envision Galleries</p>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="about.jsp">About</a>
            <a href="login.jsp">Login</a>
	    <a href="Public?action=logout">Logout</a>
	    <a href="Public?action=toRegister">Register</a>
	    <p>Hello ${loggedInUser.first_name}</p>
        </nav>
    </body>
</html>
