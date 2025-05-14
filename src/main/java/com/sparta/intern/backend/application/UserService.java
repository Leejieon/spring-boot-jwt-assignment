package com.sparta.intern.backend.application;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.sparta.intern.backend.application.dto.request.UserSignUpRequestServiceDto;
import com.sparta.intern.backend.application.dto.response.UserSignUpResponseServiceDto;
import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.UserRole;
import com.sparta.intern.backend.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserSignUpResponseServiceDto signUp(UserSignUpRequestServiceDto requestDto) {
		User user = User.createUser(
			requestDto.username(),
			requestDto.password(),
			requestDto.nickname(),
			Set.of(UserRole.USER)
		);
		User savedUser = userRepository.save(user);

		return UserSignUpResponseServiceDto.from(savedUser);
	}
}
