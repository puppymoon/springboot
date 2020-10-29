package com.moontea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moontea.dto.UserForm;
import com.moontea.entity.User;
import com.moontea.repo.UserRepository;

@Controller
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "register";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		User user = userRepository.findByUsernameAndPassword(username, password);
		if (user != null) {
			session.setAttribute("user", user);
			return "index";
		}
		return "login";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "login";
	}

	@PostMapping("/register")
	public String register(@Valid UserForm userForm, BindingResult result) {
		if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
			logger.info("password confirm failed");
			result.rejectValue("confirmPassword", "confirmError", "密碼不一樣");
		}

		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				logger.info(
						fieldError.getField() + " : " + fieldError.getDefaultMessage() + " : " + fieldError.getCode());
			}
			return "register";
		}

		User user = userForm.convertToUser();
		userRepository.save(user);
		return "redirect:/login";
	}

	@GetMapping("/exception")
	public void test500Page() {
		throw new RuntimeException();
	}

}
