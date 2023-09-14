CREATE TABLE meeting_rooms (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_name VARCHAR(255) NOT NULL,
    seating_capacity INT NOT NULL,
    total_meetings_conducted INT NOT NULL,
    ratings DECIMAL(3, 2) NOT NULL
);

INSERT INTO meeting_rooms (room_name, seating_capacity, total_meetings_conducted, ratings)
VALUES
    ('Meeting Room A', 10, 5, 4.5),
    ('Meeting Room B', 12, 8, 4.2);

CREATE TABLE meetings (
    meeting_id INT PRIMARY KEY AUTO_INCREMENT,
    room_id INT NOT NULL,
    meeting_name VARCHAR(255) NOT NULL,
    start_time DATETIME NOT NULL,
    duration_hours INT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES meeting_rooms (room_id)
);

INSERT INTO meetings (room_id, meeting_name, start_time, duration_hours)
VALUES
    (1, 'Team Meeting', '2023-09-12 14:00:00', 1),
    (2, 'Project Kickoff', '2023-09-14 10:00:00', 2);
