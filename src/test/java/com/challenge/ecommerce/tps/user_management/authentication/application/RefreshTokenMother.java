package com.challenge.ecommerce.tps.user_management.authentication.application;

import com.challenge.ecommerce.tps.user_management.authentication.domain.RefreshToken;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class RefreshTokenMother {
	private Long refreshTokenId = 1L;
	private String token = "defaultRefreshToken";
	private String accessToken = "defaultAccessToken";
	private OffsetDateTime expiryTime = OffsetDateTime.now(ZoneOffset.UTC).plusDays(1);
	private Long userId = 1L;

	public RefreshTokenMother withRefreshTokenId(Long refreshTokenId) {
		this.refreshTokenId = refreshTokenId;
		return this;
	}

	public RefreshTokenMother withToken(String token) {
		this.token = token;
		return this;
	}

	public RefreshTokenMother withAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public RefreshTokenMother withExpiryTime(OffsetDateTime expiryTime) {
		this.expiryTime = expiryTime;
		return this;
	}

	public RefreshTokenMother withUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public RefreshToken build() {
		return new RefreshToken(refreshTokenId, token, accessToken, expiryTime, userId);
	}
}
