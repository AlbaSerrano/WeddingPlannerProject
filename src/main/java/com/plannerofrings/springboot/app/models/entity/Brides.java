package com.plannerofrings.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "brides")
public class Brides implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name_bride")
	@Size(min = 3, max = 12)
	private String nameBride;

	@Column(name = "name_groom")
	@Size(min = 3, max = 12)
	private String nameGroom;

	@Column(name = "about_her")
	@Size(min = 10, max = 1000)
	private String aboutHer;

	private String bridePhoto;

	@Column(name = "about_him")
	@Size(min = 10, max = 1000)
	private String aboutHim;

	private String groomPhoto;

	@Column(name = "wedding_date")
	@Temporal(TemporalType.DATE)
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date weddingDate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_wedding")
	private Wedding wedding;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_history")
	private History history;

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public Brides() {
	}

	public Brides(@Size(min = 3, max = 12) String nameBride, @Size(min = 3, max = 12) String nameGroom,
			@Size(min = 10, max = 1000) String aboutHer, String bridePhoto, @Size(min = 10, max = 1000) String aboutHim,
			String groomPhoto, @Future Date weddingDate) {
		this.nameBride = nameBride;
		this.nameGroom = nameGroom;
		this.aboutHer = aboutHer;
		this.bridePhoto = bridePhoto;
		this.aboutHim = aboutHim;
		this.groomPhoto = groomPhoto;
		this.weddingDate = weddingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameBride() {
		return nameBride;
	}

	public void setNameBride(String nameBride) {
		this.nameBride = nameBride;
	}

	public String getNameGroom() {
		return nameGroom;
	}

	public void setNameGroom(String nameGroom) {
		this.nameGroom = nameGroom;
	}

	public String getAboutHer() {
		return aboutHer;
	}

	public void setAboutHer(String aboutHer) {
		this.aboutHer = aboutHer;
	}

	public String getBridePhoto() {
		return bridePhoto;
	}

	public void setBridePhoto(String bridePhoto) {
		this.bridePhoto = bridePhoto;
	}

	public String getAboutHim() {
		return aboutHim;
	}

	public void setAboutHim(String aboutHim) {
		this.aboutHim = aboutHim;
	}

	public String getGroomPhoto() {
		return groomPhoto;
	}

	public void setGroomPhoto(String groomPhoto) {
		this.groomPhoto = groomPhoto;
	}

	public Date getWeddingDate() {
		return weddingDate;
	}

	public void setWeddingDate(Date weddingDate) {
		this.weddingDate = weddingDate;
	}

	public Wedding getWedding() {
		return wedding;
	}

	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}

	@Override
	public String toString() {
		return "Brides [id=" + id + ", nameBride=" + nameBride + ", nameGroom=" + nameGroom + ", aboutHer=" + aboutHer
				+ ", bridePhoto=" + bridePhoto + ", aboutHim=" + aboutHim + ", groomPhoto=" + groomPhoto
				+ ", weddingDate=" + weddingDate + "]";
	}

	private static final long serialVersionUID = 1L;

}
