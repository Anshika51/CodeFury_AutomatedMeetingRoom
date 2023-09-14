// Function to handle the import button click event
document.getElementById('importButton').addEventListener('click', function () {
    // Validate user input
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const phone = document.getElementById('phone').value;
    const role = document.getElementById('role').value;

    if (!name || !email || !phone || !role) {
        alert('All fields are mandatory.');
        return;
    }

    // Email and phone number validation using regular expressions
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    const phonePattern = /^\d{10}$/;

    if (!emailPattern.test(email) || !phonePattern.test(phone)) {
        alert('Email and phone should be in the correct format.');
        return;
    }

    // If the role is "Manager," set credits to 2000; otherwise, set to 0
    const credits = role === 'Manager' ? 2000 : 0;

    // Generate a unique ID (for demonstration, using a timestamp)
    const uniqueID = Date.now();

    // Display user data on the page
    const userDataContainer = document.getElementById('userData');
    userDataContainer.innerHTML = `
        <strong>Name:</strong> ${name}<br>
        <strong>Email:</strong> ${email}<br>
        <strong>Phone:</strong> ${phone}<br>
        <strong>Role:</strong> ${role}<br>
        <strong>Credits:</strong> ${credits}<br>
        <strong>Unique ID:</strong> ${uniqueID}<br><br>
    `;
});
