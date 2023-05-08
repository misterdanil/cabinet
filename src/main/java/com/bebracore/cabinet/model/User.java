package com.bebracore.cabinet.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private String oauth2Id;
	private String oauth2Resource;
	private boolean isEnabled = false;
	private List<String> favoriteProducts;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getOauth2Id() {
		return oauth2Id;
	}

	public void setOauth2Id(String oauth2Id) {
		this.oauth2Id = oauth2Id;
	}

	public String getOauth2Resource() {
		return oauth2Resource;
	}

	public void setOauth2Resource(String oauth2Resource) {
		this.oauth2Resource = oauth2Resource;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<String> getFavoriteProducts() {
		return favoriteProducts;
	}

	public void setFavoriteProducts(List<String> favoriteProducts) {
		this.favoriteProducts = favoriteProducts;
	}

}
