package com.sparta.intern.backend.infrastructure.jwt.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenStrategy extends JwtStrategy {

	@Value("${jwt.expiration.refresh-token}")
	private Long expiration;

	public RefreshTokenStrategy(@Value("${jwt.secret}")	String secret) {
		super(secret);
	}

	@Override
	protected Long getExpirationMillis() {
		return this.expiration;
	}
}
