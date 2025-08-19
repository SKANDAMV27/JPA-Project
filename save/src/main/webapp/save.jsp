<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
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
    <div class="card shadow p-4 rounded-4" style="max-width: 500px; width: 100%;">
      <h2 class="text-center mb-3">Operation</h2>
      <h5 class="text-muted text-center mb-4">Save The Data</h5>

      <form action="save" method="post">

      <c:forEach items="${errors}" var="error">
                      <div class="field-error">${error.defaultMessage}</div>
                    </c:forEach>

        <div class="mb-3">
          <label for="nameId" class="form-label">Name</label>
          <input type="text" class="form-control" id="nameId" name="name" required>
        </div>

        <div class="mb-3">
          <label for="emailId" class="form-label">Email</label>
          <input type="email" class="form-control" id="emailId" name="email" required>
        </div>

        <div class="mb-3">
          <label for="ageId" class="form-label">Age</label>
          <input type="number" class="form-control" id="ageId" name="age" required>
        </div>

        <div class="mb-3">
          <label for="phoneId" class="form-label">Phone Number</label>
          <input type="tel" class="form-control" id="phoneId" name="number" pattern="[6-9][0-9]{9}" required>
          <div class="form-text">Must be 10 digits and start with 6, 7, 8, or 9.</div>
        </div>

        <div class="d-grid">
          <button type="submit" class="btn btn-primary btn-lg rounded-pill">💾 Save</button>
        </div>
      </form>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
