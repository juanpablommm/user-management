package com.challenge.ecommerce.tps.user_management.authentication.domain;

import java.time.OffsetDateTime;
import java.util.Objects;

public class RefreshToken {

	private final String token;

	private final String accessToken;

	private final OffsetDateTime expiryTime;

	private final Long userId;

	public RefreshToken(String token, String accessToken, OffsetDateTime expiryTime, Long userId) {
		this.token = token;
		this.accessToken = accessToken;
		this.expiryTime = expiryTime;
		this.userId = userId;
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
		return Objects.equals(getToken(), that.getToken()) && Objects.equals(getAccessToken(), that.getAccessToken())
				&& Objects.equals(getExpiryTime(), that.getExpiryTime())
				&& Objects.equals(getUserId(), that.getUserId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getToken(), getAccessToken(), getExpiryTime(), getUserId());
	}

	@Override
	public String toString() {
		return "RefreshToken{" + "token='" + token + '\'' + ", accessToken='" + accessToken + '\'' + ", expiryTime="
				+ expiryTime + ", userId=" + userId + '}';
	}
}
