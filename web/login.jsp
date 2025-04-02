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
	    <a href="Public?action=logout">Logout</a>
	    <a href="Public?action=toRegister">Register</a>
	    <p>Hello ${loggedInUser.first_name}</p>
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
	    <input type="hidden" name="action" value="login"/>
	    <div class="form-outline form-white mb-4">
		<label class="form-label" for="username">Email</label>
		<input type="text" id="username" name="email" class="form-control form-control-lg" />
	    </div>
	    <div class="form-outline form-white mb-4">
		<label class="form-label" for="password">Password</label>
		<input type="text" id="password" name="password" class="form-control form-control-lg" />
	    </div>
	    <input type="submit" value="Log in" />
	</form>
	
    </body>
</html>
