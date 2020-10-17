package com.moontea.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.moontea.dto.UserForm;
import com.moontea.entity.User;
import com.moontea.repo.UserRepository;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(getClass());

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
