package com.sparta.intern.backend.domain.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	USERNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "U-001", "이미 가입된 사용자입니다."),
	NICKNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "U-002", "이미 사용중인 닉네임입니다."),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U-003", "사용자를 찾을 수 없습니다."),
	PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST, "U-004", "비밀번호가 일치하지 않습니다."),
	;

	private final HttpStatus status;
	private final String code;
	private final String message;
}
