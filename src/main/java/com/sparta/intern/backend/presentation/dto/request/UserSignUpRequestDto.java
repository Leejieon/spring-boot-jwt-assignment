package com.sparta.intern.backend.presentation.dto.request;

public record UserSignUpRequestDto(
	String username,
	String password,
	String nickname
) {
}
