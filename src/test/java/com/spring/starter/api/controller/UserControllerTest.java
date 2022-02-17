package com.spring.starter.api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import com.spring.starter.BaseTest;
import com.spring.starter.api.request.user.SingUpUserReq;

@DisplayName("User Controller Test")
class UserControllerTest extends BaseTest {

	private final PasswordEncoder passwordEncoder;

	public UserControllerTest(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Test
	@DisplayName("유저 회원가입 (성공)")
	void signupUser() throws Exception {
		//Given
		String testPwd = passwordEncoder.encode("testPwd");
		SingUpUserReq singUpUserReq = new SingUpUserReq("testUserId","test@ajou.ac.kr", testPwd, "testName", 201721070, 1, "game");

		//When
		ResultActions perform = this.mockMvc.perform(
			post("/user/signup").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.objectMapper.writeValueAsString(singUpUserReq)));

		//Then
		perform.andExpect(status().isCreated());
	}

}