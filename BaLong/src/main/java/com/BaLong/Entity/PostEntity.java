package com.BaLong.Entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="post")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title", columnDefinition = "nvarchar(200) not null" )
	private String title;
	@Column(name="video", columnDefinition = "varchar(500) not null")
	private String video;
	@Column(name="date_upload", columnDefinition = "timestamp not null")
	private Timestamp dateUpload;
	@Column(name="liked", columnDefinition = "integer default 0 not null")
	private Integer liked;
	
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
	public Timestamp getDateUpload() {
		return dateUpload;
	}
	public void setDateUpload(Timestamp dateUpload) {
		this.dateUpload = dateUpload;
	}
	public Integer getLiked() {
		return liked;
	}
	public void setLiked(Integer liked) {
		this.liked = liked;
	}
	@OneToMany(mappedBy = "postId")
	private Set<LikedEntity> likedEntities;
 	
}
