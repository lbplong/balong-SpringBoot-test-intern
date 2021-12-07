package com.BaLong.Payload.Request;

import java.sql.Timestamp;

public class PostRequest {
	private Long id;
	private String token;
	private String title;
	private String video;
	private Integer liked;
	private Timestamp dateUpload;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	public Timestamp getDateUpload() {
		return dateUpload;
	}
	public void setDateUpload(Timestamp dateUpload) {
		this.dateUpload = dateUpload;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
