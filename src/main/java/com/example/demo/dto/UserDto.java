package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {

	private int uid;
	@NotEmpty
	private String uname;
	@NotEmpty
	@Size(min = 6, max = 15, message = " provide with number 6 to 15 char")
	private String password;
	@NotNull
	private String uAddress;
	@Email
	private String gmailId;

	public UserDto() {
		super();
	}

	public UserDto(int uid, String uname, String password, String uAddress, String gmailId) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.uAddress = uAddress;
		this.gmailId = gmailId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getGmailId() {
		return gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", password=" + password + ", uAddress=" + uAddress
				+ ", gmailId=" + gmailId + "]";
	}

}
