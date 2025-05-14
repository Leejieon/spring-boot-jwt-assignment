package com.sparta.intern.backend.application;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sparta.intern.backend.application.dto.request.UserSignUpRequestServiceDto;
import com.sparta.intern.backend.application.dto.response.UserSignUpResponseServiceDto;
import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.UserRole;
import com.sparta.intern.backend.domain.exception.ErrorCode;
import com.sparta.intern.backend.domain.exception.UserException;
import com.sparta.intern.backend.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

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
}
