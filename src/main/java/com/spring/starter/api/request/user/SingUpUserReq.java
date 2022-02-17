package com.spring.starter.api.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.spring.starter.db.entity.Area;
import com.spring.starter.db.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingUpUserReq {
	@NotNull
	String userId;

	@Email
	@NotNull
	String email;

	@NotNull
	String password;

	@NotNull
	String name;

	@NotNull
	Integer studentId;

	@NotNull
	Integer state;

	String area;

	public User toUserEntity(Area area, String encode) {
		return User.builder()
			.name(name)
			.email(email)
			.password(encode)
			.state(state)
			.studentId(studentId)
			.area(area)
			.userId(userId)
			.build();
	}
}
