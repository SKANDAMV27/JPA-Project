function singUpValidation(event) {
    const name = document.getElementById("NameID").value;
    const email = document.getElementById("floatingInput").value.trim();
    const phone = document.getElementById("phoneID").value.trim();
    const age = parseInt(document.getElementById("ageID").value);
    const gender = document.getElementById("genderID").value;
    const address = document.getElementById("addressID").value;
    const password = document.getElementById("passwordID").value;
    const confirmPassword = document.getElementById("ConfirmPasswordID").value;

    if (name.length < 3 || name.length > 10) {
        alert("Name must be between 3 and 10 characters.");
        return false;
    }

    const emailRegex = /^[a-zA-Z0-9._]+@gmail\.com$/;
    if (!emailRegex.test(email)) {
        alert("Invalid Gmail address.");
        return false;
    }

    const phoneRegex = /^\+91\s?[6-9]\d{9}$/;
    if (!phoneRegex.test(phone)) {
        alert("Invalid Indian phone number.");
        return false;
    }

    if (isNaN(age) || age < 15 || age > 50) {
        alert("Age must be between 15 and 50.");
        return false;
    }

    if (gender === "Choose...") {
        alert("Please select your gender.");
        return false;
    }

    if (address.length < 5) {
        alert("Address must be at least 5 characters long.");
        return false;
    }

    const passwordRegex = /^(?=.[A-Z])(?=(?:.\d){3,})(?=.[!@#$%^&()_+\[\]{};':"\\|,.<>/?]).{5,15}$/;
    if (!passwordRegex.test(password)) {
        alert("Password must be 5–15 characters, include 1 uppercase, 3 digits, and 1 special character.");
        return false;
    }

    if (password !== confirmPassword) {
        alert("Passwords do not match.");
        return false;
    }

    return true; // allow form submission
}
