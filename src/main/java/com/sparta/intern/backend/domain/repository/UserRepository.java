package com.sparta.intern.backend.domain.repository;

import java.util.Optional;

import com.sparta.intern.backend.domain.User;

public interface UserRepository {

	User save(User user);

	Optional<User> findByUsername(String username);

	boolean existsByUsername(String username);

	boolean existsByNickname(String nickname);
}
