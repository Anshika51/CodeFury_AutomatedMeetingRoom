// Sample data for meetings (replace with actual data)
const meetings = [
    { title: 'Team Meeting', room: 'Meeting Room A', date: '2023-09-12', time: '2:00 PM', duration: '1 hour' },
    { title: 'Project Kickoff', room: 'Meeting Room B', date: '2023-09-14', time: '10:00 AM', duration: '2 hours' },
    // Add more meetings as needed
];

// Function to display meetings on the page
function displayMeetings() {
    const meetingList = document.getElementById('meetingList');
    meetings.forEach((meeting) => {
        const listItem = document.createElement('li');
        listItem.classList.add('list-group-item');
        listItem.innerHTML = `
            <strong>Title:</strong> ${meeting.title}<br>
            <strong>Meeting Room:</strong> ${meeting.room}<br>
            <strong>Date:</strong> ${meeting.date}<br>
            <strong>Time:</strong> ${meeting.time}<br>
            <strong>Duration:</strong> ${meeting.duration}
        `;
        meetingList.appendChild(listItem);
    });
}

// Call the displayMeetings function to show meetings when the page loads
window.addEventListener('load', displayMeetings);
