package com.sparta.intern.backend.presentation.dto.response;

import java.util.Set;

import com.sparta.intern.backend.domain.UserRole;

public record UserSignUpResponseDto(
	Long id,
	String username,
	String nickname,
	Set<UserRole> roles
) {
	public static UserSignUpResponseDto of(Long id, String username, String nickname, Set<UserRole> roles) {
		return new UserSignUpResponseDto(id, username, nickname, roles);
	}
}
