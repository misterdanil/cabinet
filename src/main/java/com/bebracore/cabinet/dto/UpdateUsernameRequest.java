package com.bebracore.cabinet.dto;

import jakarta.validation.constraints.Pattern;

public class UpdateUsernameRequest {
	@Pattern(regexp = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$", message = "Длина имени должна быть от 8 до 20 символов и не содержать специальные символы")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
