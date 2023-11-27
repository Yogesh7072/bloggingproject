package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private int uid;
	private String uname;
	private String password;
	private String uAddress;
	@Column(unique = true)
	private String gmailId;

	public User() {
		super();
	}

	public User(int uid, String uname, String password, String uAddress, String gmailId) {
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
