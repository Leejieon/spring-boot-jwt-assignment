package com.sparta.intern.backend.infrastructure.jwt.strategy;

import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

import com.sparta.intern.backend.domain.UserRole;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public abstract class JwtStrategy {

	protected final SecretKey secretKey;

	protected JwtStrategy(String secret) {
		this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
	}

	public String generateToken(Long id, String username, Set<UserRole> roles) {
		Claims claims = createClaims(id, username, roles);
		Date now = new Date();
		Date expiredAt = new Date(now.getTime() + getExpirationMillis());

		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(now)
			.setExpiration(expiredAt)
			.signWith(secretKey, SignatureAlgorithm.HS256)
			.compact();
	}

	protected Claims createClaims(Long id, String username, Set<UserRole> roles) {
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("id", id);
		claims.put("roles", roles.stream()
			.map(Enum::name)
			.toList()
		);
		return claims;
	}

	protected abstract Long getExpirationMillis();
}
