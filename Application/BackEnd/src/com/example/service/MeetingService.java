package com.example.service;
import java.time.LocalDateTime;

import com.example.dao.MeetingRepository;
import com.example.dao.MeetingRoomRepository;
import com.example.model.Meeting;

public class MeetingService {
    private MeetingRepository meetingRepository;
    private MeetingRoomRepository meetingRoomRepository;

    public MeetingService(MeetingRepository meetingRepository, MeetingRoomRepository meetingRoomRepository) {
        this.meetingRepository = meetingRepository;
        this.meetingRoomRepository = meetingRoomRepository;
    }

    public boolean organizeMeeting(Meeting meeting) {
        // Check meeting room availability
        if (!meetingRoomRepository.isRoomAvailable(meeting.getId(), meeting.getStartTime(), meeting.getDurationInHours())) {
            return false; // Room is not available
        }

        // Calculate per-hour charges
        double perHourCharges = calculatePerHourCharges(meeting.getRoomName());

        // Implement other business logic for organizing the meeting
        // ...
        
        // Add the meeting to the repository
        meetingRepository.addMeeting(meeting);
        return true;
    }

	private double calculatePerHourCharges(String roomName) {
		// TODO Auto-generated method stub
		return 0;
	}

    // Implement other methods as needed
}
