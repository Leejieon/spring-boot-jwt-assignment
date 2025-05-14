package com.sparta.intern.backend.domain;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

	@Setter
	private Long id;
	private String username;
	private String password;
	private String nickname;
	private Set<UserRole> roles;

	public static User createUser(String username, String password, String nickname, Set<UserRole> roles) {
		return User.builder()
			.username(username)
			.password(password)
			.nickname(nickname)
			.roles(roles)
			.build();
	}
}
