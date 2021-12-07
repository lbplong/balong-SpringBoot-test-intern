package com.BaLong.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "accounts")

public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "full_name", columnDefinition = "varchar(20) not null")
	private String fullName;
	@Column(name = "username", columnDefinition = "varchar(20) not null")
	private String username;
	@Column(name = "email_address", columnDefinition = "varchar(50) not null")
	private String emailAddress;
	@Column(name = "password", columnDefinition = "varchar(20) not null")
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Set<LikedEntity> getLikedEntities() {
		return likedEntities;
	}
	public void setLikedEntities(Set<LikedEntity> likedEntities) {
		this.likedEntities = likedEntities;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy = "accountId", cascade = CascadeType.ALL)
	private Set<LikedEntity> likedEntities;
	
}
