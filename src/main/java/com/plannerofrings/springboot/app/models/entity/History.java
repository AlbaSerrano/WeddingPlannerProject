package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "histories")
public class History implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "how_meet")
	@Size(min = 10, max = 1200)
	private String howMeet;

	private String howMeetPhoto;

	@Column(name = "time_together")
	@Size(min = 10, max = 1200)
	private String timeTogether;

	private String timeTogetherPhoto;

	@Column(name = "wedding_request")
	@Size(min = 10, max = 1200)
	private String weddingRequest;

	private String weddingRequestPhoto;

	public History() {
	}

	public History(@Size(min = 10, max = 1200) String howMeet, String howMeetPhoto,
			@Size(min = 10, max = 1200) String timeTogether, String timeTogetherPhoto,
			@Size(min = 10, max = 1200) String weddingRequest, String weddingRequestPhoto) {
		this.howMeet = howMeet;
		this.howMeetPhoto = howMeetPhoto;
		this.timeTogether = timeTogether;
		this.timeTogetherPhoto = timeTogetherPhoto;
		this.weddingRequest = weddingRequest;
		this.weddingRequestPhoto = weddingRequestPhoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHowMeet() {
		return howMeet;
	}

	public void setHowMeet(String howMeet) {
		this.howMeet = howMeet;
	}

	public String getHowMeetPhoto() {
		return howMeetPhoto;
	}

	public void setHowMeetPhoto(String howMeetPhoto) {
		this.howMeetPhoto = howMeetPhoto;
	}

	public String getTimeTogether() {
		return timeTogether;
	}

	public void setTimeTogether(String timeTogether) {
		this.timeTogether = timeTogether;
	}

	public String getTimeTogetherPhoto() {
		return timeTogetherPhoto;
	}

	public void setTimeTogetherPhoto(String timeTogetherPhoto) {
		this.timeTogetherPhoto = timeTogetherPhoto;
	}

	public String getWeddingRequest() {
		return weddingRequest;
	}

	public void setWeddingRequest(String weddingRequest) {
		this.weddingRequest = weddingRequest;
	}

	public String getWeddingRequestPhoto() {
		return weddingRequestPhoto;
	}

	public void setWeddingRequestPhoto(String weddingRequestPhoto) {
		this.weddingRequestPhoto = weddingRequestPhoto;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", howMeet=" + howMeet + ", howMeetPhoto=" + howMeetPhoto + ", timeTogether="
				+ timeTogether + ", timeTogetherPhoto=" + timeTogetherPhoto + ", weddingRequest=" + weddingRequest
				+ ", weddingRequestPhoto=" + weddingRequestPhoto + "]";
	}

	private static final long serialVersionUID = 1L;

}
