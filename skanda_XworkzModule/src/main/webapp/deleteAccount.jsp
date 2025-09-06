<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <title>Sign In Form</title>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="x-workz-logo.jpg" alt="Logo" width="90" height="40"
             class="d-inline-block align-text-top">
      </a>
      <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <div class="d-flex">
          <a href="signIn.jsp" class="btn btn-outline-primary me-2">Sign In</a>
          <a href="signUp.jsp" class="btn btn-primary">Sign Up</a>
        </div>
      </div>
    </div>
  </nav>

  <!-- Hero Section -->
  <section class="bg-light text-center p-5">
    <div class="container">
      <h1 class="display-4 fw-bold">X-Workz</h1>
      <p class="lead mt-3">Learn. Build. Grow. Your journey to becoming a skilled developer starts here.</p>
    </div>
  </section>

  <!-- Sign In Form -->
  <section class="container my-5">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card shadow-lg">
          <div class="card-body">
            <h3 class="text-center mb-4">Delete The Account</h3>

            <!-- Display Messages -->
            <c:if test="${not empty message}">
              <div class="alert alert-success">${message}</div>
            </c:if>
            <c:if test="${not empty error}">
              <div class="alert alert-danger">${error}</div>
            </c:if>

            <form action="deleteAccount" method="post">
              <!-- Email -->
              <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" placeholder="Enter your email"
                       name="userEmail" required>
              </div>
              <!-- Submit -->
              <div class="d-grid">
                <button type="submit" class="btn btn-success">Account Delete</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
