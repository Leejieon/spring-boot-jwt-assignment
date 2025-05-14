package com.sparta.intern.backend.infrastructure.jwt;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.sparta.intern.backend.domain.UserRole;
import com.sparta.intern.backend.infrastructure.jwt.strategy.AccessTokenStrategy;
import com.sparta.intern.backend.infrastructure.jwt.strategy.RefreshTokenStrategy;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtUtil {

	private final AccessTokenStrategy accessTokenStrategy;
	private final RefreshTokenStrategy refreshTokenStrategy;

	public String generateAccessToken(Long id, String username, Set<UserRole> roles) {
		return accessTokenStrategy.generateToken(id, username, roles);
	}

	public String generateRefreshToken(Long id, String username, Set<UserRole> roles) {
		return refreshTokenStrategy.generateToken(id, username, roles);
	}
}
