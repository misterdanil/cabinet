package com.bebracore.cabinet.repository;

public interface CustomUserRepository {
	void updatePassword(String email, String password);

	boolean existsByFavoriteProduct(String userId, String productId);
}
