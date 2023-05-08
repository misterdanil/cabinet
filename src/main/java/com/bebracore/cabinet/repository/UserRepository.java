package com.bebracore.cabinet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bebracore.cabinet.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>, CustomUserRepository {
	User findByEmail(String email);

	User findByUsername(String username);

	User findByoauth2IdAndOauth2Resource(String id, String resource);

	boolean existsByEmail(String email);

	void removeByoauth2IdAndOauth2Resource(String id, String resource);
}
