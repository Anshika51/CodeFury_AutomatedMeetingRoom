package com.example.dao;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Meeting;

public class MeetingRepository {
    private List<Meeting> meetings = new ArrayList<>();
    private int nextMeetingId = 1;

    public void addMeeting(Meeting meeting) {
        meeting.setId(nextMeetingId++);
        meetings.add(meeting);
    }

    public List<Meeting> getAllMeetings() {
        return meetings;
    }

    public boolean isMeetingRoomAvailable(String roomName, LocalDateTime startTime, int durationInHours) {
        // Implement logic to check if the meeting room is available at the specified time
        for (Meeting meeting : meetings) {
            if (meeting.getRoomName().equals(roomName)) {
                LocalDateTime meetingStartTime = meeting.getStartTime();
                int meetingDuration = meeting.getDurationInHours();
                LocalDateTime meetingEndTime = meetingStartTime.plusHours(meetingDuration);

                if (startTime.isBefore(meetingEndTime) && startTime.plusHours(durationInHours).isAfter(meetingStartTime)) {
                    return false; // Room is not available
                }
            }
        }
        return true; // Room is available
    }

    // Add more methods to manage meetings, check availability, and calculate charges
}


