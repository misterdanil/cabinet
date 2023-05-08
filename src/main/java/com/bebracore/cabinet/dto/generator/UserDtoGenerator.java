package com.bebracore.cabinet.dto.generator;

import com.bebracore.cabinet.dto.UserDto;
import com.bebracore.cabinet.model.User;

public class UserDtoGenerator {
	private UserDtoGenerator() {
	}

	public static UserDto createUserDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setFirstName(user.getFirstName());
		dto.setLastName(user.getLastName());
		dto.setUsername(user.getUsername());

		return dto;
	}
}
