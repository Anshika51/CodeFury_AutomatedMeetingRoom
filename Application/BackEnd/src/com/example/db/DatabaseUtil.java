package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/meeting"; // Update with your database URL
    private static final String JDBC_USER = "root"; // Update with your database username
    private static final String JDBC_PASSWORD = "root"; // Update with your database password

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Create a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
