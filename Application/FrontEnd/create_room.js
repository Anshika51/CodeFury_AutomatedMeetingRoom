// Function to handle the create room form submission
document.getElementById('createRoomForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // Get user input values
    const name = document.getElementById('name').value.trim();
    const capacity = parseInt(document.getElementById('capacity').value);
    const amenities = getSelectedAmenities();

    // Validation rules
    if (!name || !capacity || isNaN(capacity) || capacity <= 0) {
        alert('Name and Seating Capacity are mandatory and must be valid.');
        return;
    }

    if (isNameDuplicate(name)) {
        alert('Name must be unique.');
        return;
    }

    if (amenities.length < 2) {
        alert('At least 2 amenities should be selected.');
        return;
    }

    // Calculate per-hour charges based on seating capacity and amenities
    const perHourCharges = calculatePerHourCharges(capacity, amenities);

    // Generate a unique ID (for demonstration, using a timestamp)
    const uniqueID = generateUniqueID();

    // Display the calculated per-hour charges
    alert(`Per Hour Charges: ${perHourCharges} credits`);

    // Reset the form (optional)
    document.getElementById('createRoomForm').reset();
});

// Function to get selected amenities
function getSelectedAmenities() {
    const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
    const amenities = [];

    checkboxes.forEach(checkbox => {
        amenities.push(checkbox.id);
    });

    return amenities;
}

// Function to check if the name is duplicate (replace with your logic)
function isNameDuplicate(name) {
    // Simulated check for name duplication (you should replace this with your database check)
    const existingNames = ['Meeting Room A', 'Meeting Room B', 'Meeting Room C'];
    return existingNames.includes(name);
}

// Function to calculate per-hour charges based on seating capacity and amenities
function calculatePerHourCharges(capacity, amenities) {
    let perHourCharges = 0;

    // Calculate charges based on seating capacity
    if (capacity <= 5) {
        perHourCharges += 0;
    } else if (capacity <= 10) {
        perHourCharges += 10;
    } else {
        perHourCharges += 20;
    }

    // Calculate charges based on selected amenities
    amenities.forEach(amenity => {
        switch (amenity) {
            case 'projector':
                perHourCharges += 5;
                break;
            case 'wifi':
                perHourCharges += 10;
                break;
            case 'conferenceCall':
                perHourCharges += 15;
                break;
            case 'whiteboard':
                perHourCharges += 5;
                break;
            case 'waterDispenser':
                perHourCharges += 5;
                break;
            case 'tv':
                perHourCharges += 10;
                break;
            case 'coffeeMachine':
                perHourCharges += 10;
                break;
            // Add cases for other amenities as needed
        }
    });

    return perHourCharges;
}

// Function to generate a unique ID (for demonstration, using a timestamp)
function generateUniqueID() {
    return Date.now();
}
