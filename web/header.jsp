<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="navbar navbar-expand-lg navbar-light bg-light border-bottom shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold text-primary" href="index.jsp">
            Envision Galleries
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="about.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Public?action=allArt">All Art</a>
                </li>
                <c:if test="${loggedInUser.role.equals('Admin')}">
                    <li class="nav-item">
                        <a class="nav-link" href="Private?action=AddPage">Add Art</a>
                    </li>
                </c:if>

            </ul>
	    <div class="right">
		<c:if test="${not empty loggedInUser}">
		    <a href="Public?action=logout">${loggedInUser.first_name}</a>
		</c:if>    
	    </div>
        </div>
    </div>
</header>