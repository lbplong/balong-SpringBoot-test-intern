package com.BaLong.Payload.Response;

public class AccountResponse {
	private Long id;
	private String username;
	private String fullName;
	
	public AccountResponse(Long id, String username, String fullName) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
