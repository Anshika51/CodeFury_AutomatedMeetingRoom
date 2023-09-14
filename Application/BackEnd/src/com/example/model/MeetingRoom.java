package com.example.model;

public class MeetingRoom {
	private int id;
    private String name;
    private int capacity;
    private int totalMeetingsConducted;
    private double ratings;
	public MeetingRoom(int id, String name, int capacity, int totalMeetingsConducted, double ratings) {
		super();
		this.id = id;
		this.name = name;
		this.capacity = capacity;
		this.totalMeetingsConducted = totalMeetingsConducted;
		this.ratings = ratings;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getTotalMeetingsConducted() {
		return totalMeetingsConducted;
	}
	public void setTotalMeetingsConducted(int totalMeetingsConducted) {
		this.totalMeetingsConducted = totalMeetingsConducted;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", name=" + name + ", capacity=" + capacity + ", totalMeetingsConducted="
				+ totalMeetingsConducted + ", ratings=" + ratings + "]";
	}
    
}
