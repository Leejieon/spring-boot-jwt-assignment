package com.sparta.intern.backend.presentation.dto.request;

public record UserLoginRequestDto(
	String username,
	String password
) {
}
