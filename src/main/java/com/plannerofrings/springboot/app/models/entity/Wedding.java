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
@Table(name = "wedding")
public class Wedding implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ceremony_place")
	@Size(min = 5, max = 30)
	private String ceremonyPlace;

	@Column(name = "ceremony_hour")
	private String ceremonyHour;

	@Column(name = "ceremony_description")
	@Size(min = 10, max = 1200)
	private String ceremonyDescription;

	private String ceremonyPhoto;

	@Column(name = "party_place")
	@Size(min = 5, max = 30)
	private String partyPlace;

	@Column(name = "party_hour")
	private String partyHour;

	@Column(name = "party_description")
	@Size(min = 10, max = 1200)
	private String partyDescription;

	private String partyPhoto1;

	private String partyPhoto2;

	public Wedding() {

	}

	public Wedding(@Size(min = 5, max = 30) String ceremonyPlace, String ceremonyHour,
			@Size(min = 10, max = 1200) String ceremonyDescription, String ceremonyPhoto,
			@Size(min = 5, max = 30) String partyPlace, String partyHour,
			@Size(min = 10, max = 1200) String partyDescription, String partyPhoto1, String partyPhoto2) {
		this.ceremonyPlace = ceremonyPlace;
		this.ceremonyHour = ceremonyHour;
		this.ceremonyDescription = ceremonyDescription;
		this.ceremonyPhoto = ceremonyPhoto;
		this.partyPlace = partyPlace;
		this.partyHour = partyHour;
		this.partyDescription = partyDescription;
		this.partyPhoto1 = partyPhoto1;
		this.partyPhoto2 = partyPhoto2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCeremonyPlace() {
		return ceremonyPlace;
	}

	public void setCeremonyPlace(String ceremonyPlace) {
		this.ceremonyPlace = ceremonyPlace;
	}

	public String getCeremonyPhoto() {
		return ceremonyPhoto;
	}

	public void setCeremonyPhoto(String ceremonyPhoto) {
		this.ceremonyPhoto = ceremonyPhoto;
	}

	public String getCeremonyHour() {
		return ceremonyHour;
	}

	public void setCeremonyHour(String ceremonyHour) {
		this.ceremonyHour = ceremonyHour;
	}

	public String getCeremonyDescription() {
		return ceremonyDescription;
	}

	public void setCeremonyDescription(String ceremonyDescription) {
		this.ceremonyDescription = ceremonyDescription;
	}

	public String getPartyPlace() {
		return partyPlace;
	}

	public String getPartyPhoto1() {
		return partyPhoto1;
	}

	public void setPartyPhoto1(String partyPhoto1) {
		this.partyPhoto1 = partyPhoto1;
	}

	public String getPartyPhoto2() {
		return partyPhoto2;
	}

	public void setPartyPhoto2(String partyPhoto2) {
		this.partyPhoto2 = partyPhoto2;
	}

	public void setPartyPlace(String partyPlace) {
		this.partyPlace = partyPlace;
	}

	public String getPartyHour() {
		return partyHour;
	}

	public void setPartyHour(String partyHour) {
		this.partyHour = partyHour;
	}

	public String getPartyDescription() {
		return partyDescription;
	}

	public void setPartyDescription(String partyDescription) {
		this.partyDescription = partyDescription;
	}

	@Override
	public String toString() {
		return "Wedding [id=" + id + ", ceremonyPlace=" + ceremonyPlace + ", ceremonyHour=" + ceremonyHour
				+ ", ceremonyDescription=" + ceremonyDescription + ", ceremonyPhoto=" + ceremonyPhoto + ", partyPlace="
				+ partyPlace + ", partyHour=" + partyHour + ", partyDescription=" + partyDescription + ", partyPhoto1="
				+ partyPhoto1 + ", partyPhoto2=" + partyPhoto2 + "]";
	}

	private static final long serialVersionUID = 1L;

}
