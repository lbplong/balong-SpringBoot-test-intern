package com.BaLong.Payload.Response;

public class RegisterResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String emailAddress;
	private String fullName;
	private String message;
	
	public RegisterResponse (String token, Long id, String emailAddress, String fullName, String message ) {
		this.token = token;
		this.id= id;
		this.emailAddress=emailAddress;
		this.fullName= fullName;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	};
	
	
}
