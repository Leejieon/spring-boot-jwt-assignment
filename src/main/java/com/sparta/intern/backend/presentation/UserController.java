package com.sparta.intern.backend.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.intern.backend.application.UserService;
import com.sparta.intern.backend.application.dto.request.UserLoginRequestServiceDto;
import com.sparta.intern.backend.application.dto.request.UserSignUpRequestServiceDto;
import com.sparta.intern.backend.application.dto.response.UserLoginResponseServiceDto;
import com.sparta.intern.backend.application.dto.response.UserSignUpResponseServiceDto;
import com.sparta.intern.backend.presentation.dto.request.UserLoginRequestDto;
import com.sparta.intern.backend.presentation.dto.request.UserSignUpRequestDto;
import com.sparta.intern.backend.presentation.dto.response.UserLoginResponseDto;
import com.sparta.intern.backend.presentation.dto.response.UserSignUpResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<UserSignUpResponseDto> signup(@RequestBody UserSignUpRequestDto requestDto) {
		UserSignUpResponseServiceDto responseDto = userService.signUp(UserSignUpRequestServiceDto.of(
			requestDto.username(),
			requestDto.password(),
			requestDto.nickname()
		));

		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(UserSignUpResponseDto.of(
				responseDto.id(),
				responseDto.username(),
				responseDto.nickname(),
				responseDto.roles()
			));
	}

	@PostMapping("/login")
	public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
		UserLoginResponseServiceDto responseDto = userService.login(
			UserLoginRequestServiceDto.of(requestDto.username(), requestDto.password())
		);

		return ResponseEntity
			.status(HttpStatus.OK)
			.body(UserLoginResponseDto.of(
				responseDto.accessToken(),
				responseDto.refreshToken()
			));
	}
}
