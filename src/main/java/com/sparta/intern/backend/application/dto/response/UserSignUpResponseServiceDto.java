package com.sparta.intern.backend.application.dto.response;

import java.util.Set;

import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.UserRole;

public record UserSignUpResponseServiceDto(
	Long id,
	String username,
	String nickname,
	Set<UserRole> roles
) {
	public static UserSignUpResponseServiceDto from(User user) {
		return new UserSignUpResponseServiceDto(
			user.getId(),
			user.getUsername(),
			user.getNickname(),
			user.getRoles()
		);
	}
}
