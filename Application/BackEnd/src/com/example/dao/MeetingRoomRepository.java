package com.example.dao;
import java.util.ArrayList;
import java.util.List;

import com.example.db.DatabaseUtil;
import com.example.model.MeetingRoom;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MeetingRoomRepository {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public MeetingRoomRepository() {
        // Initialize with dummy meeting room data (replace with a database)
        meetingRooms.add(new MeetingRoom(1, "Meeting Room A", 10, 5, 4.5));
        meetingRooms.add(new MeetingRoom(2, "Meeting Room B", 12, 8, 4.2));
        // Add more meeting rooms as needed
    }

    public List<MeetingRoom> getAllMeetingRooms() {
        return meetingRooms;
    }

//    public boolean isMeetingRoomAvailable(String roomName, LocalDateTime startTime, int durationInHours) {
//        // Implement logic to check meeting room availability
//        // You may need to compare with existing meetings in the room
//        // For demonstration, we assume all rooms are always available
//        return true;
//    }
    public boolean isRoomAvailable(int roomId, String meetingDate, String startTime, int duration) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection (you should have a DatabaseUtil class or similar)
            connection = DatabaseUtil.getConnection();

            // Prepare the SQL query to check availability
            String sql = "SELECT COUNT(*) FROM meetings WHERE room_id = ? AND meeting_date = ? " +
                         "AND (TIME_TO_SEC(start_time) <= TIME_TO_SEC(?) AND TIME_TO_SEC(start_time) + ? * 3600 >= TIME_TO_SEC(?))";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);
            statement.setString(2, meetingDate);
            statement.setString(3, startTime);
            statement.setInt(4, duration);
            statement.setString(5, startTime);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                // If count is greater than 0, the room is not available for the specified time
                return count == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        } finally {
            // Close resources (connection, statement, resultSet) in a finally block
            //DatabaseUtil.close(resultSet);
            //DatabaseUtil.close(statement);
            //DatabaseUtil.close(connection);
        }

        return false; // Default to room not available if an exception occurs
    }
    
    public double calculatePerHourCharges(int roomId, int duration) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection (you should have a DatabaseUtil class or similar)
            connection = DatabaseUtil.getConnection();

            // Prepare the SQL query to get amenities cost and seating capacity cost for the room
            String sql = "SELECT amenities_cost, seating_capacity FROM meeting_rooms WHERE room_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, roomId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double amenitiesCost = resultSet.getDouble("amenities_cost");
                int seatingCapacity = resultSet.getInt("seating_capacity");

                // Calculate per-hour charges
                double perHourCharges = (amenitiesCost + seatingCapacity) * duration;

                return perHourCharges;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        } finally {
            // Close resources (connection, statement, resultSet) in a finally block
//            DatabaseUtil.close(resultSet);
//            DatabaseUtil.close(statement);
//            DatabaseUtil.close(connection);
        }

        return 0.0; // Default to zero charges if an exception occurs or room data not found
    }
    // Add more methods for adding, updating, or retrieving meeting rooms as required

}
