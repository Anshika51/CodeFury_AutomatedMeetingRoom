// Function to handle the organize meeting form submission
document.getElementById('organizeMeetingForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // Get user role (replace with actual logic to fetch user role)
    const userRole = getUserRole();

    // Get form input values
    const title = document.getElementById('title').value.trim();
    const meetingDate = new Date(document.getElementById('meetingDate').value);
    const startTime = document.getElementById('startTime').value;
    const duration = parseInt(document.getElementById('duration').value);
    const meetingType = document.getElementById('meetingType').value;
    const selectedMeetingRoom = document.getElementById('meetingRoom').value;

    // Validation rules
    if (!title || !meetingDate || !startTime || isNaN(duration) || duration <= 0 || !meetingType || !selectedMeetingRoom) {
        alert('All fields are mandatory.');
        return;
    }

    // Check if meeting date and time are in the future
    const now = new Date();
    if (meetingDate < now || (meetingDate.getTime() === now.getTime() && startTime <= now.toLocaleTimeString())) {
        alert('Meeting date and time should be in the future.');
        return;
    }

    // Check meeting room availability (replace with your logic)
    if (!isMeetingRoomAvailable(selectedMeetingRoom, meetingDate, startTime, duration)) {
        alert('The selected meeting room is not available at the specified time.');
        return;
    }

    // Check seating capacity of the meeting room (replace with your logic)
    const requiredSeatingCapacity = calculateRequiredSeatingCapacity(); // Calculate based on participants
    if (!isSeatingCapacitySufficient(selectedMeetingRoom, requiredSeatingCapacity)) {
        alert('The meeting room does not have sufficient seating capacity.');
        return;
    }

    // Check if the user is a manager and has enough credits
    if (userRole === 'Manager') {
        const perHourCharges = calculatePerHourCharges(); // Calculate per-hour charges
        const deductedCredits = deductManagerCredits(perHourCharges); // Deduct credits

        if (deductedCredits === false) {
            alert('Insufficient credits to book the room.');
            return;
        }
    }

    // Validate amenities based on meeting type (replace with your logic)
    if (!validateAmenities(meetingType)) {
        alert('Selected amenities do not match the meeting type.');
        return;
    }

    // Generate a Unique ID (for demonstration, using a timestamp)
    const uniqueID = generateUniqueID();

    // Proceed with booking the room (update your code accordingly)
    bookMeetingRoom();
});

// Function to check meeting room availability (replace with your logic)
function isMeetingRoomAvailable(meetingRoom, date, startTime, duration) {
    // Implement your logic to check availability of the meeting room
    return true; // For demonstration purposes
}

// Function to calculate required seating capacity (replace with your logic)
function calculateRequiredSeatingCapacity() {
    // Calculate based on the number of participants
    return 10; // For demonstration purposes
}

// Function to check if seating capacity is sufficient (replace with your logic)
function isSeatingCapacitySufficient(meetingRoom, requiredCapacity) {
    // Implement your logic to check seating capacity
    return true; // For demonstration purposes
}

// Function to deduct credits from manager's account
function deductManagerCredits(perHourCharges) {
    // Check if manager has sufficient credits
    const managerCredits = 2000; // Manager's initial credits (you may fetch this from the database)
    if (managerCredits >= perHourCharges) {
        // Deduct credits from manager's account
        // Update managerCredits in the database (subtract perHourCharges)
        return true;
    } else {
        // Insufficient credits
        return false;
    }
}

// Function to calculate per-hour charges (replace with your calculation logic)
function calculatePerHourCharges() {
    // Calculate per-hour charges based on amenities and seating capacity
    const amenitiesCost = calculateAmenitiesCost();
    const seatingCapacityCost = calculateSeatingCapacityCost();

    return amenitiesCost + seatingCapacityCost;
}

// Function to validate amenities based on meeting type (replace with your logic)
function validateAmenities(meetingType) {
    // Implement your logic to validate amenities
    return true; // For demonstration purposes
}

// Function to generate a unique ID (for demonstration, using a timestamp)
function generateUniqueID() {
    return Date.now();
}

// Function to fetch the user's role (replace with your logic)
function getUserRole() {
    // Replace this with your code to fetch the user's role
    return 'Manager'; // For demonstration purposes
}
