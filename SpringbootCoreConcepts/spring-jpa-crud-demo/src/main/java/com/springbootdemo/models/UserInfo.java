package com.springbootdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//import javax.persistence.Table;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor

// @Table(name="UsersInfo")
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userID;
	
	private String emailID;
	private String username;
	private String password;
	private Integer phoneNo;
	
	/*
	 * public Integer getPhoneNo() { return phoneNo; } public void
	 * setPhoneNo(Integer phoneNo) { this.phoneNo = phoneNo; }
	 * 
	 * public Integer getUserID() { return userID; } public void setUserID(Integer
	 * userID) { this.userID = userID; } public String getEmailID() { return
	 * emailID; } public void setEmailID(String emailID) { this.emailID = emailID; }
	 * public String getUsername() { return username; } public void
	 * setUsername(String username) { this.username = username; } public String
	 * getPassword() { return password; } public void setPassword(String password) {
	 * this.password = password; }
	 * 
	 * @Override public String toString() { return "UserInfo [userID=" + userID +
	 * ", emailID=" + emailID + ", username=" + username + ", password=" + password
	 * + ", phoneNo=" + phoneNo + "]"; }
	 */
}
