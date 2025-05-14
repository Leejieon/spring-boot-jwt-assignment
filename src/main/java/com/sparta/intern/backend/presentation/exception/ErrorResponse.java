package com.sparta.intern.backend.presentation.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

	private final String code;
	private final String message;

	public static ErrorResponse of(String code, String message) {
		return new ErrorResponse(code, message);
	}
}
