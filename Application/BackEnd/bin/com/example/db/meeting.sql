create database meeting;
use meeting;
CREATE TABLE meeting_rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    seating_capacity INT NOT NULL,
    projector BOOLEAN,
    wifi BOOLEAN,
    conference_call BOOLEAN,
    whiteboard BOOLEAN,
    water_dispenser BOOLEAN,
    tv BOOLEAN,
    coffee_machine BOOLEAN
);


CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    role ENUM('Admin', 'Manager', 'Member') NOT NULL,
    credits INT NOT NULL,
    unique_id BIGINT NOT NULL
);


CREATE TABLE meetings (
    meeting_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    meeting_date DATE NOT NULL,
    start_time TIME NOT NULL,
    duration INT NOT NULL,
    meeting_type VARCHAR(255) NOT NULL,
    organizer_id INT NOT NULL,
    room_id INT NOT NULL,
    FOREIGN KEY (organizer_id) REFERENCES users(user_id),
    FOREIGN KEY (room_id) REFERENCES meeting_rooms(room_id)
);


