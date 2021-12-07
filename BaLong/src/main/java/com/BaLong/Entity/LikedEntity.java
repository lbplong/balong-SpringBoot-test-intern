package com.BaLong.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "liked")
public class LikedEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	@Column(name = "account_id")
//	private Long accountId;
//	@Column(name = "post_id")
//	private Long postId;
	@Column(name = "liked", columnDefinition = "integer default 0 not null")
	private Integer liked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Long getAccountId() {
//		return accountId;
//	}
//
//	public void setAccountId(Long accountId) {
//		this.accountId = accountId;
//	}
//
//	public Long getPostId() {
//		return postId;
//	}
//
//	public void setPostId(Long postId) {
//		this.postId = postId;
//	}

	public Integer getLiked() {
		return liked;
	}

	public void setLiked(Integer liked) {
		this.liked = liked;
	}

	@ManyToOne
	@JoinColumn(name = "account_id", columnDefinition = "bigint", nullable = false)
	private AccountEntity accountId;
	

	@ManyToOne
	@JoinColumn(name = "post_id", columnDefinition = "bigint", nullable = false)
	private PostEntity postId;
	public AccountEntity getAccountId() {
		return accountId;
	}

	public void setAccountId(AccountEntity accountId) {
		this.accountId = accountId;
	}

	public PostEntity getPostId() {
		return postId;
	}

	public void setPostId(PostEntity postId) {
		this.postId = postId;
	}
}
