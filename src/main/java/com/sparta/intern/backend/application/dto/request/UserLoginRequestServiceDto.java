package com.sparta.intern.backend.application.dto.request;

public record UserLoginRequestServiceDto(
	String username,
	String password
) {
	public static UserLoginRequestServiceDto of(String username, String password) {
		return new UserLoginRequestServiceDto(username, password);
	}
}
