// Function to handle the login form submission
document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // Get user input values
    const userID = document.getElementById('userID').value;
    const email = document.getElementById('email').value;

    // Validate User ID and Email
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

    if (!userID.trim()) {
        showValidationError('User ID is required.');
        return;
    }

    if (!email.trim() || !emailPattern.test(email)) {
        showValidationError('Email is required and should be in a valid format.');
        return;
    }

    // Replace with your actual logic to determine the user's role
    // For demonstration, we assume user roles based on a simple condition
    let role;
    if (userID === 'admin') {
        role = 'Admin';
    } else if (userID === 'manager') {
        role = 'Manager';
    } else {
        role = 'Member';
    }

    // Redirect to the respective page based on the role
    switch (role) {
        case 'Admin':
            window.location.href = 'admin.html';
            break;
        case 'Manager':
            window.location.href = 'manager.html';
            break;
        case 'Member':
            window.location.href = 'member.html';
            break;
        default:
            alert('Invalid User ID or Email.');
            break;
    }
});

// Function to show validation error messages
function showValidationError(message) {
    const validationDivs = document.querySelectorAll('.invalid-feedback');
    validationDivs.forEach(div => {
        div.textContent = message;
        div.style.display = 'block';
    });
}
