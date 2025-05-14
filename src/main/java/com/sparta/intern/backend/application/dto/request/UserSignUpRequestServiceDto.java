package com.sparta.intern.backend.application.dto.request;

public record UserSignUpRequestServiceDto(
	String username,
	String password,
	String nickname
) {
	public static UserSignUpRequestServiceDto of(String username, String password, String nickname) {
		return new UserSignUpRequestServiceDto(username, password, nickname);
	}
}
