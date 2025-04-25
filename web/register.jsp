<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>Register</title>
    </head>
    <body>
        <!-- Include Header -->
        <jsp:include page="header.jsp" />

        <!-- Register Form Container -->
        <div class="login-card">
            <div class="text-center mb-4">
                <span class="brand-text">Envision Galleries</span>
            </div>
            <p class="text-center text-muted">Create your account and start your journey</p>

            <p class="text-danger">${errors.general}</p>

            <form action="Public" method="post">
                <input type="hidden" name="action" value="register" />

                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="firstName">First Name</label>
                    <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Enter your first name" required />
                </div>

                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="lastName">Last Name</label>
                    <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Enter your last name" required />
                </div>

                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="email">Email</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Enter your email" required />
		    <p class="text-danger">${errors.email}</p>
                </div>

                <div class="form-outline form-white mb-4">
                    <label class="form-label" for="password">Password</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="Enter your password" required />
		     <p class="text-danger">${errors.password}</p>
                </div>

                <button type="submit" class="btn login-btn btn-block">Register</button>
            </form>
        </div>
    </body>
</html>