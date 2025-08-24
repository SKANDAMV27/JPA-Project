<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Save Data</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

  <div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow p-4 rounded-4" style="max-width: 450px; width: 100%;">
      <h2 class="text-center mb-3">Operation</h2>
      <h5 class="text-muted text-center mb-4">Save ID and Name</h5>

      <form action="delete" method="post">



        <!-- Name field -->
        <div class="mb-3">
          <label for="nameField" class="form-label">Name</label>
          <input type="text" class="form-control" id="nameField" name="name" required>
        </div>

        <div class="d-grid">
          <button type="submit" class="btn btn-success btn-lg rounded-pill">TO Delete</button>
        </div>
      </form>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
