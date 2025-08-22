<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forgot Password - X-Workz</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp">
      <img src="x-workz-logo.jpg" alt="Logo" width="90" height="40" class="d-inline-block align-text-top">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
      aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
      <div class="d-flex">
        <a href="signUp.jsp" class="btn btn-outline-primary me-2">Sign Up</a>
        <a href="signIn.jsp" class="btn btn-primary">Sign In</a>
      </div>
    </div>
  </div>
</nav>

<!-- Hero / Info Section -->
<section class="bg-light text-center p-5">
  <div class="container">
    <h1 class="display-5 fw-bold">Welcome to X-Workz</h1>
    <p class="lead mt-3">Learn. Build. Grow. X-Workz helps you enhance your development skills with real-world projects and training.</p>
    <p>Our mission is to provide students and professionals a hands-on platform to improve coding, web development, and software engineering expertise.</p>
  </div>
</section>

<!-- Forgot Password Form -->
<section class="container my-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card shadow-lg">
        <div class="card-body">
          <h3 class="text-center mb-4">Forgot Password</h3>

          <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
          </c:if>
          <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
          </c:if>

          <form action="forgotPassword" method="post">
            <!-- Email -->
            <div class="mb-3">
              <label>Email</label>
              <input type="email" name="userEmail" class="form-control" placeholder="Enter your email" required>
            </div>

            <!-- OTP -->
            <div class="mb-3">
              <label>OTP</label>
              <input type="text" name="otp" class="form-control" placeholder="Enter OTP" maxlength="6">
            </div>

            <!-- Buttons -->
            <div class="d-flex justify-content-between">
              <button type="submit" class="btn btn-primary btn-sm">Send OTP</button>
              <button type="submit" class="btn btn-success">Verify & Reset Password</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- Footer -->
<footer class="bg-dark text-white text-center p-3">
  <p>&copy; 2025 X-Workz | All Rights Reserved</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
