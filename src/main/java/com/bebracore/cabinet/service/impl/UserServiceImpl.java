package com.bebracore.cabinet.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bebracore.cabinet.model.User;
import com.bebracore.cabinet.repository.UserRepository;
import com.bebracore.cabinet.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findById(String id) {
		Optional<User> opt = userRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		}

		return opt.get();
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByoauth2IdAndOauth2Resource(String id, String registrationId) {
		return userRepository.findByoauth2IdAndOauth2Resource(id, registrationId);
	}

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public boolean existsById(String String) {
		return userRepository.existsById(String);
	}

	public boolean existsByFavoriteProduct(String userId, String productId) {
		return userRepository.existsByFavoriteProduct(userId, productId);
	}

	public void updatePassword(String email, String password) {
		userRepository.updatePassword(email, password);
	}

	public void removeByoauth2IdAndOauth2Resource(String id, String registrationId) {
		userRepository.removeByoauth2IdAndOauth2Resource(id, registrationId);
	}

}
