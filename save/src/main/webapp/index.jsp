<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Operation Page</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

  <div class="container d-flex flex-column justify-content-center align-items-center vh-100">
    <div class="card shadow p-4 rounded-4" style="max-width: 400px; width: 100%;">
      <h2 class="text-center mb-3">Operation</h2>
      <h5 class="text-muted text-center mb-4">Choose your action</h5>

      <div class="d-grid gap-3">
        <a href="save.jsp" class="btn btn-primary btn-lg rounded-pill"> Save</a>
        <a href="updateName.jsp" class="btn btn-warning btn-lg rounded-pill"> Update</a>
        <a href="delete.jsp" class="btn btn-danger btn-lg rounded-pill"> Delete</a>
        <a href="view" class="btn btn-success btn-lg rounded-pill"> View</a>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

