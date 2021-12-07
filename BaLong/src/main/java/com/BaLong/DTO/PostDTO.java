package com.BaLong.DTO;

import java.sql.Timestamp;

public class PostDTO extends AbstractDTO {
	private String title;
	private Timestamp dateUpLoad;
	private Integer liked;
	private String video;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getDateUpLoad() {
		return dateUpLoad;
	}

	public void setDateUpLoad(Timestamp dateUpLoad) {
		this.dateUpLoad = dateUpLoad;
	}

	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
}
