package com.sparta.intern.backend.domain.repository;

import com.sparta.intern.backend.domain.User;

public interface UserRepository {

	User save(User user);

	boolean existsByUsername(String username);

	boolean existsByNickname(String nickname);
}
