<%-- 
    Document   : login
    Created on : Mar 24, 2025, 12:42:09 PM
    Author     : anthony williams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Envision Galleries Login</title>
    </head>
    <body>
        <p>Login</p>
        <nav>
            <a href="index.jsp">Home</a>
            <a href="about.jsp">About</a>
            <a href="login.jsp">Login</a>
        </nav>
        
        <img></img>
        <p>
            Imagine, Dream, Create, Display
        </p>
        <p>
            ​Art by Ann Williams
        </p>
        
	<p>${errors}</p>
	
        <form action="Public" method="post">
            <input type="hidden" name="action" value="login">
            <label>Email: </label>
            <input type="text" name="email">
            <br>
            <label>Password: </label>
            <input type="text" name="password">
            <br>
            <input type="submit" value="login">
        </form>
        
        <form action="Public" method="post">
            <input type="hidden" name="action" value="toRegister">
            <input type="submit" value="Register">
        </form>
    </body>
</html>
