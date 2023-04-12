package com.xworkz.finalProject.dto;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SingUp {
	@NotNull
	private int id;
	@Size(min=3,max=20,message="UserId cannot be less than 3 or graterthan 20")
	private String userId;
	@Size(min=3,max=40,message="email cannot be less than 3 or graterthan 20")
	private String email;
	@NotNull
	private Long mobile;
	@Size(min=8,max=16,message="Password cannot be lessthan 8 or greaterthan 16")
	private String password;
	@Size(min=8,max=16,message="ConfirmPassword Should be same as password")
	private String confirmPassword;
	
	private String acceptAgrement;
	
	private int count;
	
	//private boolean resetPassword;

}
