package com.agile.solarerc.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=20)
	private String username;
	
	@Column(nullable=false,unique=true,length=45)
	private String email;
	
	@Column(nullable=false,length=64)
	private String password;
	
	@Column(columnDefinition = "varchar(255) default 'false'")
	private String loggedin;

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

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	 public String getLoggedin() {
		return loggedin;
	}

	public void setLoggedin(String loggedin) {
		this.loggedin = loggedin;
	}

	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof User)) return false;
	        User user = (User) o;
	        return Objects.equals(username, user.username) &&
	                Objects.equals(password, user.password);
	    }
}
