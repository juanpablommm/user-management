package com.challenge.ecommerce.tps.user_management.authentication.domain;

import java.time.OffsetDateTime;
import java.util.Objects;

public class RefreshToken {

	private final Long refreshTokenId;

	private final String token;

	private final String accessToken;

	private final OffsetDateTime expiryTime;

	private final Long userId;

	public RefreshToken(Long refreshTokenId, String token, String accessToken, OffsetDateTime expiryTime, Long userId) {
		this.refreshTokenId = refreshTokenId;
		this.token = token;
		this.accessToken = accessToken;
		this.expiryTime = expiryTime;
		this.userId = userId;
	}

	public static RefreshToken createToAuth(String token, String accessToken, OffsetDateTime expiryTime, Long userId) {
		return new RefreshToken(null, token, accessToken, expiryTime, userId);
	}

	public Long getRefreshTokenId() {
		return refreshTokenId;
	}

	public String getToken() {
		return token;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public OffsetDateTime getExpiryTime() {
		return expiryTime;
	}

	public Long getUserId() {
		return userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RefreshToken that = (RefreshToken) o;
		return Objects.equals(getRefreshTokenId(), that.getRefreshTokenId())
				&& Objects.equals(getToken(), that.getToken())
				&& Objects.equals(getAccessToken(), that.getAccessToken())
				&& Objects.equals(getExpiryTime(), that.getExpiryTime())
				&& Objects.equals(getUserId(), that.getUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRefreshTokenId(), getToken(), getAccessToken(), getExpiryTime(), getUserId());
	}

	@Override
	public String toString() {
		return "RefreshToken{" + "refreshTokenId=" + refreshTokenId + ", token='" + token + '\'' + ", accessToken='"
				+ accessToken + '\'' + ", expiryTime=" + expiryTime + ", userId=" + userId + '}';
	}
}
