package com.xworkz.finalProject.controller;

import java.time.LocalTime;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.finalProject.dto.SingUp;
import com.xworkz.finalProject.service.SignUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class SignUpController {
	@Autowired
	private SignUpService signUpService;

	public SignUpController() {
		log.info("Running SignUpController in controller");

	}

	@PostMapping("/signup")
	public String onSignUp(Model model, SingUp singUp) {
		log.info("Running onSignUp in controller");
		Set<ConstraintViolation<SingUp>> violations = this.signUpService.validateAndSave(singUp);
		if (violations != null && violations.isEmpty() && singUp != null) {
			model.addAttribute("message", "Data Saved Successfully...");
			log.info("" + singUp);
			return "index";
		} else {
			model.addAttribute("errors", violations);
			model.addAttribute("errorMsg", "Data not Saved");

		}
		return "index";

	}

	@PostMapping("/signin")
	public String onSignIn(@RequestParam String userId, @RequestParam String password, Model model,
			HttpServletRequest request) {
		log.info("Running signin method in controller");
		try {
			SingUp dto = this.signUpService.signIn(userId, password);

			if (dto.getCount() >= 3) {
				model.addAttribute("message", "Account locked Please Reset the password Again");
				return "SignIn";
			} else if (dto != null) {
				log.info("UserId and Password are matching");
				if (dto.getResetPassword() == true) {
					log.info("Running Reset true condition in controller");
					if (!dto.getResetTime().isAfter(LocalTime.now())) {
						log.info("Running reset time in controller");
						model.addAttribute("alert", "Your Timeout Please Reset password again");
						return "SignIn";
					}
					model.addAttribute("userID", dto.getUserId());
					log.info("Running in reset condition");
					log.info("ResetPassword---" + dto.getResetPassword());
					log.info("Timer-----" + dto.getResetTime().isBefore(LocalTime.now()));
					return "UpdatePassword";
				}
				System.currentTimeMillis();
				log.info("User ID and password is matched");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userID", dto.getUserId());
				return "LoginSuccessPage";
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
		model.addAttribute("errorMsg", "UserId or Password not Matching");
		return "SignIn";

	}

	@PostMapping("/reset")
	public String resetPassword(String email, Model model) {
		log.info("Running reset password in controller");
		try {
			SingUp up = this.signUpService.resetPassword(email);
			if (up.getResetPassword() == true) {
				model.addAttribute("message", "Password reset successfully please login within 1 min ");
				return "ResetPassword";
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return "ResetPassword";

	}

	@PostMapping("/updatePassword")
	public String updatePassword(String userId, String password, String confirmPassword) {
		this.signUpService.updatePassword(userId, password, confirmPassword);
		return "UpdateSuccesPage";

	}

}
