package com.moontea.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.moontea.entity.User;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

public class UserForm {

	@NotBlank(message = "不能為空")
	private String username;

	@NotBlank
	@Length(min = 6, message = "密碼長度至少需要6位")
	private String password;

//	@Pattern(regexp = "")
	@NotBlank
	private String phone;

	@Email(message = "請輸入電子信箱")
	@NotBlank
	private String email;

	@NotBlank
	private String confirmPassword;

	public UserForm() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public User convertToUser() {
		User user = new UserFormConvert().convert(this);
		return user;
	}

	private class UserFormConvert implements FormConvert<UserForm, User> {

		@Override
		public User convert(UserForm userForm) {
			User user = new User();
			BeanUtils.copyProperties(userForm, user);
			return user;
		}
	}

}
