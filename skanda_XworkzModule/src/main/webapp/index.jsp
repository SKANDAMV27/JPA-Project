<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <title>X-Workz</title>

  <!-- Custom CSS -->
  <style>
    body {
      background: linear-gradient(to right, #f8f9fa, #e9ecef);
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      padding-top: 70px;  /* space for fixed navbar */
      padding-bottom: 70px; /* space for fixed footer */
    }

    .navbar {
      background-color: #fff !important;
    }

    /* Fix header (navbar) */
    .navbar.fixed-top {
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    .hero-section {
      background: linear-gradient(135deg, #667eea, #764ba2);
      color: #fff;
      padding: 120px 0;
      text-align: center;
    }

    .hero-section h1 {
      font-size: 3rem;
      font-weight: 700;
    }

    .hero-section p {
      font-size: 1.25rem;
    }

    .feature-card {
      border: none;
      border-radius: 15px;
      box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
      transition: transform 0.3s ease;
    }

    .feature-card:hover {
      transform: translateY(-10px);
    }

    /* Fix footer */
    footer {
      background: #343a40;
      color: #fff;
      padding: 15px 20px;
      position: fixed;
      bottom: 0;
      width: 100%;
    }

    footer .footer-content {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .footer-left {
      flex: 1;
    }

    .footer-center {
      flex: 1;
      text-align: center;
    }

    .footer-right {
      flex: 1;
      text-align: right;
    }

    #dateTime {
      margin: 0;
    }
  </style>
</head>
<body>

  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light shadow-sm fixed-top">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
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
          <a href="deleteAccount.jsp" class="btn btn-danger">Delete</a>
        </div>
      </div>
    </div>
  </nav>

  <!-- Messages from Spring -->
  <div class="container mt-4">
      <%-- JSTL tags for messages --%>
      <c:if test="${not empty message}">
          <div class="alert alert-success alert-dismissible fade show" role="alert">
              ${message}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
      </c:if>
      <c:if test="${not empty error}">
          <div class="alert alert-danger alert-dismissible fade show" role="alert">
              ${error}
              <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
          </div>
      </c:if>
  </div>

  <!-- Hero Section -->
  <section class="hero-section">
    <div class="container">
      <h1 class="display-4 fw-bold">Welcome to X-Workz ODC</h1>
      <p class="lead mt-3">Learn. Build. Grow. Start your journey to becoming a skilled developer today!</p>
      <a href="signUp.jsp" class="btn btn-light btn-lg mt-3">Get Started</a>
    </div>
  </section>

  <!-- Features Section -->
  <section class="py-5">
    <div class="container">
      <div class="row text-center g-4">
        <div class="col-md-4">
          <div class="card feature-card p-4">
            <div class="card-body">
              <h5 class="card-title fw-bold">Learn</h5>
              <p class="card-text">Access top-notch resources and mentorship to master new skills.</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card feature-card p-4">
            <div class="card-body">
              <h5 class="card-title fw-bold">Build</h5>
              <p class="card-text">Work on real-world projects to enhance your experience and portfolio.</p>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="card feature-card p-4">
            <div class="card-body">
              <h5 class="card-title fw-bold">Grow</h5>
              <p class="card-text">Connect with peers and industry experts to advance your career.</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Footer -->
  <footer>
    <div class="container footer-content">
      <div class="footer-left"></div>
      <div class="footer-center">
        <p>&copy; <span id="year"></span> X-Workz ODC. All rights reserved.</p>
      </div>
      <div class="footer-right">
        <p id="dateTime"></p>
      </div>
    </div>
  </footer>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"></script>

  <!-- Custom JS for Date & Time -->
  <script>
    function updateDateTime() {
      const now = new Date();
      document.getElementById("year").textContent = now.getFullYear();
      document.getElementById("dateTime").textContent = now.toLocaleString();
    }

    // Run once on load
    updateDateTime();

    // Update every second
    setInterval(updateDateTime, 1000);
  </script>

</body>
</html>
