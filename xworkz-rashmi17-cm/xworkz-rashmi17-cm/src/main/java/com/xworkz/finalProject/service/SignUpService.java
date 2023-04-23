package com.xworkz.finalProject.service;

import java.util.Collections;


import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;


import com.xworkz.finalProject.dto.SingUp;
import com.xworkz.finalProject.entity.AddTechnologyEntity;

public interface SignUpService {

	Set<ConstraintViolation<SingUp>> validateAndSave(SingUp sign);

	default List<SingUp> findAll() {
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

	default SingUp signIn(String userId, String password) {
		return null;
	}

	boolean sendEmail(String email, String text);

	default SingUp resetPassword(String email) {
		return null;
	}

	default SingUp updatePassword(String userId, String password, String confirmPassword) {
		return null;

	}
	
	default SingUp updateProfile(String userId,String email,Long mobile,String path) {
		return null;
	}
	
	default SingUp addTech(String userId,AddTechnologyEntity technologyEntity ) {
		return null;
	}
	
	default List<AddTechnologyEntity> viewTech(String userId) {
		return null;
		
	}
	

}
