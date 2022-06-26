package com.example.bookshop.dto;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private long id;
	private String name;
	private String username;
	private String passWord;
	private String phone;
	private String email;
	private String address;
	private boolean gender;
	private boolean status;
	private String createdDate;
	private String updatedDate;

	private List<String> roles;

	private String message;

	public JwtResponse(String token, long id, String name, String username, String passWord, String phone, String email,
			String address, boolean gender, boolean status, String createdDate, String updatedDate, List<String> roles,
			String message) {
		super();
		this.token = token;
		this.id = id;
		this.name = name;
		this.username = username;
		this.passWord = passWord;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.roles = roles;
		this.message = message;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

}
