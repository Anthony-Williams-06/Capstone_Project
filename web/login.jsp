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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Envision Galleries Login</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <!-- Include Header -->
        <jsp:include page="header.jsp" />

        <!-- Login Form Container -->
        <div class="login-card">
            <div class="text-center mb-4">
                <span class="brand-text">Envision Galleries</span>
            </div>
            <p class="text-center text-muted">Imagine, Dream, Create, Display</p>
            <p class="text-center text-muted">Art by Ann Williams</p>
	    <p class="text-danger">${errors.general}</p>
            <form action="Public" method="post">
                <input type="hidden" name="action" value="login" />
                
                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="username">Email</label>
                    <input type="text" id="username" name="email" class="form-control" placeholder="Enter your email" required />
		    <p class="text-danger">${errors.email}</p>
                </div>

                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Enter your password" required />
		    <p class="text-danger">${errors.password}</p>
                </div>

                <button type="submit" class="btn login-btn btn-block">Log In</button>
            </form>
        </div>
    </body>
</html>