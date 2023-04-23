package com.xworkz.finalProject.controller;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.finalProject.dto.SingUp;
import com.xworkz.finalProject.entity.AddTechnologyEntity;
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
				log.info("User ID and password is matched");
				HttpSession httpSession = request.getSession(true);
				httpSession.setAttribute("userID", dto.getUserId());
				httpSession.setAttribute("picture", dto.getPictureName());
				httpSession.setAttribute("userDto", dto);
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
				model.addAttribute("message", "Password reset successfully please login within 2 min ");
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

	@PostMapping("/profile")
	public String updateProfile(@RequestParam("chitra") MultipartFile multipartFile, String userId, String email,
			Long mobile, Model model) throws IOException {
		log.info("multipartFile" + multipartFile);
		log.info("multipartFile original FileName" + multipartFile.getOriginalFilename());
		String formate = multipartFile.getOriginalFilename().substring(
				multipartFile.getOriginalFilename().lastIndexOf('.'), multipartFile.getOriginalFilename().length());
		log.info("image format" + formate);
		log.info("multipartFile content type" + multipartFile.getContentType());
		log.info("multipartFile size" + multipartFile.getSize());
		log.info("multipartFile in bytes" + multipartFile.getBytes());
		if (multipartFile.isEmpty()) {
			log.info("Running upload image checking in isEmpty condition");
			model.addAttribute("imgError", "Nothing selected please select file");
			return "UpdateProfile";
		}
		model.addAttribute("uploded", "image sent successfully");
		byte[] bytes = multipartFile.getBytes();

		Path path = Paths.get("D:\\img\\" + userId + System.currentTimeMillis() + formate);
		Files.write(path, bytes);
		String image = path.getFileName().toString();
		log.info("image" + image);
		log.info("image in toString" + path.toString());
		log.info("Image FileName" + path.getFileName());
		this.signUpService.updateProfile(userId, email, mobile, image);
		return "UpdateProfile";

	}

	@GetMapping("/download")
	public void downlodImage(HttpServletResponse servletResponse, @RequestParam String fileName, SingUp singUp)
			throws IOException {
try {
		Path path = Paths.get("D:\\img\\" + singUp.getPictureName() + ".jpg");
		path.toFile();
		servletResponse.setContentType("image/jpeg");
		File file = new File("D:\\img\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = servletResponse.getOutputStream();
		IOUtils.copy(in, out);
		servletResponse.flushBuffer();
}catch (FileNotFoundException e) {
	e.getStackTrace();
}
	
}

	
	
	@PostMapping("/addTech")
	public String onAddTech(String userId,AddTechnologyEntity addTechnologyEntity,Model model) {
		SingUp dto=this.signUpService.addTech(userId, addTechnologyEntity);
		log.info("userid"+userId);
		model.addAttribute("added", "Technologies informations are added..");
		model.addAttribute("entity", addTechnologyEntity);
		return "AddTechnology";
		
	}
	
	@GetMapping("/view")
	public String onView(@RequestParam String userId,Model model) {
		List<AddTechnologyEntity> listEntity=this.signUpService.viewTech(userId);
		log.info("Running onView");
		model.addAttribute("viewer", listEntity);
		return "ViewTechnology";
		
	}

}
