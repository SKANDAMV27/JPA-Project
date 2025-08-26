<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Get All Data from Db</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <div class="container">
        <a class="navbar-brand" href="#">Xworkz</a>
        <a class="nav-link text-white" href="index.jsp">
            <i class="bi bi-house-fill"></i> Home
        </a>
    </div>
</nav>

<div class="container mt-4">
    <h1 class="mb-4 text-center">Get All Data from Db</h1>


    <table class="table table-bordered table-hover table-striped text-center align-middle">
        <thead class="table-danger">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Phone</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="dto" items="${entity}">
                <tr>
                    <td>${dto.id}</td>
                    <td>${dto.userName}</td>
                    <td>${dto.userEmail}</td>
                    <td>${dto.userAge}</td>
                    <td>${dto.userNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>