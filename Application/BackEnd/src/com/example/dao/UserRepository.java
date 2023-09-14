package com.example.dao;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, String> users = new HashMap<>(); // Email to Role mapping

    public UserRepository() {
        // Initialize with dummy user data (replace with a database)
        users.put("admin@example.com", "Admin");
        users.put("manager@example.com", "Manager");
        users.put("member@example.com", "Member");
    }

    public String getUserRole(String email) {
        return users.get(email);
    }
}
