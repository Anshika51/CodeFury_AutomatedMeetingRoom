package com.example.model;

import java.time.LocalDateTime;

public class Meeting {
	private int id;
    private String title;
    private LocalDateTime startTime;
    private int durationInHours;
    private String meetingType;
    private String organizerEmail;
    private String roomName;
    
	@Override
	public String toString() {
		return "Meeting [id=" + id + ", title=" + title + ", startTime=" + startTime + ", durationInHours="
				+ durationInHours + ", meetingType=" + meetingType + ", organizerEmail=" + organizerEmail
				+ ", roomName=" + roomName + "]";
	}
	public Meeting(int id, String title, LocalDateTime startTime, int durationInHours, String meetingType,
			String organizerEmail, String roomName) {
		super();
		this.id = id;
		this.title = title;
		this.startTime = startTime;
		this.durationInHours = durationInHours;
		this.meetingType = meetingType;
		this.organizerEmail = organizerEmail;
		this.roomName = roomName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public String getMeetingType() {
		return meetingType;
	}
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}
	public String getOrganizerEmail() {
		return organizerEmail;
	}
	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
    
}
