 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@ page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Sign Up Form</title>
  </head>
  <body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-sm">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img src="x-workz-logo.jpg" alt="Logo" width="90" height="40"
               class="d-inline-block align-text-top">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
          aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
          <div class="d-flex">
            <button class="btn btn-outline-primary me-2">Sign In</button>
            <button class="btn btn-primary">Sign Up</button>
          </div>
        </div>
      </div>
    </nav>

    <!-- Hero Section -->
    <section class="bg-light text-center p-5">
      <div class="container">
        <h1 class="display-4 fw-bold">Welcome to X-Workz</h1>
        <p class="lead mt-3">Learn. Build. Grow. Your journey to becoming a skilled developer starts here.</p>
      </div>
    </section>

    <!-- Sign Up Form -->
    <section class="container my-5">
      <div class="row justify-content-center">
        <div class="col-md-6">
          <div class="card shadow-lg">
            <div class="card-body">
              <h3 class="text-center mb-4">Sign In</h3>
              <form action="signUp" method="post">


              <c:forEach items="${errors}" var="error">
                <div class="field-error">${error.defaultMessage}</div>
              </c:forEach>
               <h1>${errorMessage}</h1>
              <h1>${success}</h1>
              <h3>${password}</h3>
                <!-- Name -->
                <div class="mb-3">
                  <label class="form-label">Name</label>
                  <input type="text" class="form-control" placeholder="Enter your name" name="userName" required>
                </div>
                <!-- Phone -->
                <div class="mb-3">
                  <label class="form-label">Phone Number</label>
                  <input type="tel" class="form-control" placeholder="Enter phone number" name="phoneNumber" required>
                </div>
                <!-- Email -->
                <div class="mb-3">
                  <label class="form-label">Email</label>
                  <input type="email" class="form-control" placeholder="Enter your email" name="userEmail" required>
                </div>
                <!-- Age -->
                <div class="mb-3">
                  <label class="form-label">Age</label>
                  <input type="number" class="form-control" placeholder="Enter your age" name="userAge" required>
                </div>
                <!-- Password -->
                <div class="mb-3">
                  <label class="form-label">Password</label>
                  <input type="password" class="form-control" placeholder="Enter password" name="userPassword" required>
                </div>
                <!-- Confirm Password -->
                <div class="mb-3">
                  <label class="form-label">Confirm Password</label>
                  <input type="password" class="form-control" placeholder="Re-enter password" name="conformPassword" required>
                </div>
                <!-- Address -->
                <div class="mb-3">
                  <label class="form-label">Address</label>
                  <textarea class="form-control" rows="2" placeholder="Enter your address" name="userAdress" required></textarea>
                </div>
                <!-- Gender -->
                <div class="mb-3">
                  <label class="form-label">Gender</label>
                  <div>
                    <input type="radio" name="gender" value="m"  required> Male
                    <input type="radio" name="gender" value="f" class="ms-3"> Female
                    <input type="radio" name="gender" value="o" class="ms-3"> Other
                  </div>
                </div>
                <!-- Submit -->
                <div class="d-grid">
                  <button type="submit" class="btn btn-success">Submit</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"></script>
  </body>
</html>
