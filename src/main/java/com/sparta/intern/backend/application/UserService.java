package com.sparta.intern.backend.application;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sparta.intern.backend.application.dto.request.UserLoginRequestServiceDto;
import com.sparta.intern.backend.application.dto.request.UserSignUpRequestServiceDto;
import com.sparta.intern.backend.application.dto.response.UserLoginResponseServiceDto;
import com.sparta.intern.backend.application.dto.response.UserSignUpResponseServiceDto;
import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.UserRole;
import com.sparta.intern.backend.domain.exception.ErrorCode;
import com.sparta.intern.backend.domain.exception.UserException;
import com.sparta.intern.backend.domain.repository.UserRepository;
import com.sparta.intern.backend.infrastructure.jwt.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final JwtUtil jwtUtil;

	public UserSignUpResponseServiceDto signUp(UserSignUpRequestServiceDto requestDto) {
		validateUsername(requestDto.username());
		validateNickname(requestDto.nickname());

		User user = User.createUser(
			requestDto.username(),
			requestDto.password(),
			requestDto.nickname(),
			Set.of(UserRole.USER)
		);
		User savedUser = userRepository.save(user);

		return UserSignUpResponseServiceDto.from(savedUser);
	}

	public UserLoginResponseServiceDto login(UserLoginRequestServiceDto requestDto) {
		User user = userRepository.findByUsername(requestDto.username())
			.orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

		matchPassword(user, requestDto.password());

		String accessToken = jwtUtil.generateAccessToken(user.getId(), user.getUsername(), user.getRoles());
		String refreshToken = jwtUtil.generateRefreshToken(user.getId(), user.getUsername(), user.getRoles());

		return new UserLoginResponseServiceDto(accessToken, refreshToken);
	}

	private void validateUsername(String username) {
		if (userRepository.existsByUsername(username)) {
			throw new UserException(ErrorCode.USERNAME_ALREADY_EXISTS);
		}
	}

	private void validateNickname(String nickname) {
		if (userRepository.existsByNickname(nickname)) {
			throw new UserException(ErrorCode.NICKNAME_ALREADY_EXISTS);
		}
	}

	private void matchPassword(User user, String password) { // TODO : 비밀번호 암호화
		if (!user.getPassword().equals(password)) {
			throw new UserException(ErrorCode.PASSWORD_MISMATCH);
		}
	}
}
