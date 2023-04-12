package com.xworkz.finalProject.service;

import java.util.Collections;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.finalProject.dto.SingUp;

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

default SingUp signIn(String userId,String password) {
	return null;
}
//boolean sendEmail(String email);

/*
 * default SingUp resetPassword(String email) { return null; }
 */
}
