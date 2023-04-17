package com.xworkz.finalProject.repository;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import com.xworkz.finalProject.entity.SignUpEntity;

public interface SignUpRepo {

	boolean save(SignUpEntity entity);

	default List<SignUpEntity> findAll() {
		return Collections.emptyList();

	}

	default Long findByUser(String userId) {
		return null;

	}

	default Long findByEmaiId(String email) {
		return null;

	}

	default Long findByMobileNo(Long mobile) {
		return null;

	}

	default SignUpEntity signIn(String userId) {
		return null;

	}

	default SignUpEntity resetPassword(String email) {
		return null;
	}

	boolean loginCount(String userId, int count);

	boolean update(SignUpEntity entity);

	boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime resetTime);

}
