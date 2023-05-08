package com.bebracore.cabinet.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.bebracore.cabinet.model.User;
import com.bebracore.cabinet.repository.CustomUserRepository;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
	@Autowired
	private MongoOperations mongoOperations;

	public void updatePassword(String email, String password) {
		Query query = new Query(Criteria.where("email").is(email));
		Update update = new Update();
		update.set("password", password);

		mongoOperations.updateFirst(query, update, User.class);
	}

	public boolean existsByFavoriteProduct(String userId, String productId) {
		Query query = new Query();

		query.addCriteria(Criteria.where("id").is(userId));
		query.addCriteria(Criteria.where("favoriteProducts").in(productId));

		return mongoOperations.exists(query, User.class);

	}

}
