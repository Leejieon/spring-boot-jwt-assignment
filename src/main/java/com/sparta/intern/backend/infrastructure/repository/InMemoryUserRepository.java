package com.sparta.intern.backend.infrastructure.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.sparta.intern.backend.domain.User;
import com.sparta.intern.backend.domain.repository.UserRepository;

@Repository
public class InMemoryUserRepository implements UserRepository {

	private final Map<Long, User> userStore = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong();

	@Override
	public User save(User user) {
		Long userId = idGenerator.incrementAndGet();
		user.setId(userId);
		userStore.put(userId, user);

		return user;
	}

}
