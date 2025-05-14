package com.sparta.intern.backend.application.dto.response;

public record UserLoginResponseServiceDto(
	String accessToken,
	String refreshToken
) {
}
