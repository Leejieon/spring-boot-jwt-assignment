package com.sparta.intern.backend.presentation.dto.response;

public record UserLoginResponseDto(
	String accessToken,
	String refreshToken
) {
	public static UserLoginResponseDto of(String accessToken, String refreshToken) {
		return new UserLoginResponseDto(accessToken, refreshToken);
	}
}
