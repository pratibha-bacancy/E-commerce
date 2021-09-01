package com.bacancy.spboot.dto;

public class UserDto {
	private Long id;
	private String userName;
	private String userDetail;
	private String userEmail;
	private String userContact;

	public UserDto() {

	}

	public UserDto(Long id, String userName, String userDetail, String userEmail, String userContact) {
		this.id = id;
		this.userName = userName;
		this.userDetail = userDetail;
		this.userEmail = userEmail;
		this.userContact = userContact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(String userDetail) {
		this.userDetail = userDetail;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

}
