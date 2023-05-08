package com.bebracore.cabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bebracore.cabinet.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

//	@GetMapping("/user/favorite")
//	public ResponseEntity<ValidatedResponse> getFavoriteProducts() {
//		return;
//	}
}
