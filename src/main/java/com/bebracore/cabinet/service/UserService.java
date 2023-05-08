package com.bebracore.cabinet.service;

import com.bebracore.cabinet.model.User;

public interface UserService {
	User save(User user);
	
	User findById(String id);
	
	User findByUsername(String username);

	User findByoauth2IdAndOauth2Resource(String id, String registrationId);

	boolean existsByEmail(String email);

	boolean existsById(String String);
	
	boolean existsByFavoriteProduct(String userId, String productId);

	void updatePassword(String email, String password);

	void removeByoauth2IdAndOauth2Resource(String id, String registrationId);
}
