package com.ajashn.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	private Long userid;
	

	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	private String username;
	
	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstname;
	
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "role", length = 50, nullable = false)
	private String role;
	
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	
	// No Argument Constructor
		public User() {
		}
		
		// Fields Constructor
		public User(Long userid,
				 String firstname, String lastname,
				String email, String role, String ssn) {
			super();
			this.userid = userid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.role = role;
			this.ssn = ssn;
		
		}

		public Long getUserid() {
			return userid;
		}

		public void setUserid(Long userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		@Override
		public String toString() {
			return "User [userid=" + userid + ", username=" + username + ", firstname=" + firstname + ", lastname="
					+ lastname + ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
		}
		
		
		
		
		
		
		
	
}

