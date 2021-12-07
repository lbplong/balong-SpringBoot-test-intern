package com.BaLong.Payload.Response;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String emailAddress;
	private String fullName;

	public JwtResponse(String accessToken, Long id,String emailAddress, String fullName) {
		this.token = accessToken;
		this.id = id;
		this.fullName = fullName;
		this.emailAddress=emailAddress;
	}

	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
}

