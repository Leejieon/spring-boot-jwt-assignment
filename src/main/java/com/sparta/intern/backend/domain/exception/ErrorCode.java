package com.sparta.intern.backend.domain.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	USERNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "U-001", "이미 가입된 사용자입니다."),
	NICKNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "U-002", "이미 사용중인 닉네임입니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
