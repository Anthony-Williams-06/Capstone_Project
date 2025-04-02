<%-- 
    Document   : register
    Created on : Mar 31, 2025, 1:05:08 PM
    Author     : antho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
	<p>${errors}</p>
        <form action="Public" method="post">
            <input type="hidden" name="action" value="register">
	    <div class="inputContainer">
                <label for="firstName" >First Name</label>
                <input type="text" name="firstName" id="email"/>
            </div>
	    <div class="inputContainer">
                <label for="lastName" >Last Name</label>
                <input type="text" name="lastName" id="email"/>
            </div>
            <div class="inputContainer">
                <label for="email" >Email</label>
                <input type="text" name="email" id="email"/>
            </div>
            <div class="inputContainer">
                <label for="password">Password</label>
                <input type="text" name="password" id="password" />
            </div>
	    <input type="submit" value="Register" />
        </form>
    </body>
</html>
