package com.bebracore.cabinet.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bebracore.cabinet.dto.UpdateUsernameRequest;
import com.bebracore.cabinet.model.User;
import com.bebracore.cabinet.service.UserService;
import com.bebracore.cabinet.service.error.UsernameExistException;
import com.bebracore.webconfig.controller.AbstractController;
import com.bebracore.webconfig.dto.ValidatedResponse;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class UserController extends AbstractController {
	@Autowired
	private UserService userService;

	@PutMapping("/user/username")
	public ResponseEntity<ValidatedResponse> updateUsername(
			@RequestBody @Validated UpdateUsernameRequest usernameRequest, BindingResult result) {
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(createErrorValidationResponse(result));
		}

		User user = userService.findById(SecurityContextHolder.getContext().getAuthentication().getName());

		try {
			userService.updateUsername(user, usernameRequest.getUsername());
		} catch (UsernameExistException e) {
			result.rejectValue("username", "username.exist", "Пользователь с таким именем уже существует");
			return ResponseEntity.badRequest().body(createErrorValidationResponse(result));
		}

		return ResponseEntity.ok().build();
	}

	@PutMapping("/user/avatar")
	public ResponseEntity<ValidatedResponse> updateAvatar(@RequestParam MultipartFile avatar) {
		User user = userService.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		try {
			userService.updateAvatar(user, avatar.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException("Couldn't get input stream of image", e);
		}

		return ResponseEntity.ok().build();
	}

	@GetMapping("/user/avatar")
	public void getAvatar(HttpServletResponse response) {
		User user = userService.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		if (user.getAvatar() == null) {
			response.setStatus(404);
			return;
		}
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);

		try {
			response.getOutputStream().write(user.getAvatar().getData());
		} catch (IOException e) {
			throw new RuntimeException("Couldn't write user avatar to response", e);
		}
	}
	
	@GetMapping("/user/{id}/avatar")
	public void updateAvatar(@PathVariable String id, HttpServletResponse response) {
		User user = userService.findById(id);
		if (user.getAvatar() == null) {
			response.setStatus(404);
			return;
		}
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);

		try {
			response.getOutputStream().write(user.getAvatar().getData());
		} catch (IOException e) {
			throw new RuntimeException("Couldn't write user avatar to response", e);
		}
	}
}
