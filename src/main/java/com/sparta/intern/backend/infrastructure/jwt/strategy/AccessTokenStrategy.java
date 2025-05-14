package com.sparta.intern.backend.infrastructure.jwt.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenStrategy extends JwtStrategy {

	@Value("${jwt.expiration.access-token}")
	private Long expiration;

	public AccessTokenStrategy(@Value("${jwt.secret}")	String secret) {
		super(secret);
	}

	@Override
	protected Long getExpirationMillis() {
		return this.expiration;
	}
}
