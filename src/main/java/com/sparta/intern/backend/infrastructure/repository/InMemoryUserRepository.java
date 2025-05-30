package com.sparta.intern.backend.infrastructure.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.repository.UserRepository;

@Repository
public class InMemoryUserRepository implements UserRepository {

	private final Map<String, User> userStore = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong();

	@Override
	public User save(User user) {
		Long userId = idGenerator.incrementAndGet();
		user.setId(userId);
		userStore.put(user.getUsername(), user);

		return user;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return Optional.ofNullable(userStore.get(username));
	}

	@Override
	public boolean existsByUsername(String username) {
		return userStore.values().stream()
			.anyMatch(user -> user.getUsername().equals(username));
	}

	@Override
	public boolean existsByNickname(String nickname) {
		return userStore.values().stream()
			.anyMatch(user -> user.getNickname().equals(nickname));
	}

}
