package com.example.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MeetingRoomBookingSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/meeting";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a SQL query to fetch data
            String query = "SELECT * FROM meeting_rooms";
            ResultSet resultSet = statement.executeQuery(query);

            // Print the results
            while (resultSet.next()) {
                int roomId = resultSet.getInt("room_id");
                String roomName = resultSet.getString("room_name");
                int seatingCapacity = resultSet.getInt("seating_capacity");
                int totalMeetings = resultSet.getInt("total_meetings_conducted");
                double ratings = resultSet.getDouble("ratings");

                System.out.println("Room ID: " + roomId);
                System.out.println("Room Name: " + roomName);
                System.out.println("Seating Capacity: " + seatingCapacity);
                System.out.println("Total Meetings Conducted: " + totalMeetings);
                System.out.println("Ratings: " + ratings);
                System.out.println("--------------------");
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
