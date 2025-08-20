<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome | Xworkz ODC</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="#">Xworkz ODC</a>
            <div class="d-flex">
                <a href="signOut" class="btn btn-outline-light btn-sm">Logout</a>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container text-center mt-5">
        <div class="card shadow-lg p-4 rounded-4">
            <h2 class="text-success">Welcome, <c:if test="${not empty message}">
                                                  <div class="alert alert-success text-center" role="alert">
                                                      ${message}
                                                  </div>
                                              </c:if>
 👋</h2>
            <p class="lead mt-3">You have successfully logged in to <b>Xworkz ODC Portal</b>.</p>

            <!-- Example Features -->
            <div class="row mt-4">
                <div class="col-md-4">
                    <div class="card border-0 shadow-sm p-3">
                        <h5 class="fw-bold">📊 Dashboard</h5>
                        <p>View your reports and analytics.</p>
                        <a href="#" class="btn btn-sm btn-primary">Go</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card border-0 shadow-sm p-3">
                        <h5 class="fw-bold">👤 Profile</h5>
                        <p>Manage your account details.</p>
                        <a href="#" class="btn btn-sm btn-success">Edit</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card border-0 shadow-sm p-3">
                        <h5 class="fw-bold">⚙ Settings</h5>
                        <p>Customize your preferences.</p>
                        <a href="#" class="btn btn-sm btn-warning">Update</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
