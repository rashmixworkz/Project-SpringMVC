package com.xworkz.finalProject.resouce;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.finalProject.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@Slf4j
@RequestMapping("/")
public class Ajax {
	
	@Autowired
	private SignUpService signUpService;

	public Ajax() {
		log.info("Running Ajax Constructor in Ajax");
	}

	@GetMapping(value = "/emailId/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		Long dbEmail = this.signUpService.findByEmaiId(email);
		System.err.println(dbEmail);

		if (dbEmail == 0) {
			System.err.println("Running in equals condition");
			return "";
		} else {
			return "Email id exsist";
		}
	}

	@GetMapping(value = "/userName/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String user) {
			System.out.println(user);
			Long dbUser = this.signUpService.findByUser(user);
			System.err.println(dbUser);

			if (dbUser == 0) {
				System.err.println("Running in equals condition");
			return "";
			}else {
			return "UserID exsist";
			}
	}

	@GetMapping(value = "/randomNumber/{mobile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long mobile) {
		Long dbNumber = this.signUpService.findByMobileNo(mobile);
		System.err.println(dbNumber);

		if (dbNumber == 0) {
			System.err.println("Running in equals condition");
			return "";

		} else {
			return "Mobile Number exsist";
		}
	}

}
