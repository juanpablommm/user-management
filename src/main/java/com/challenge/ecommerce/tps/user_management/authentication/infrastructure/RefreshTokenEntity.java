package com.challenge.ecommerce.tps.user_management.authentication.infrastructure;

import com.challenge.ecommerce.tps.user_management.users.infrastructure.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "refresh_token")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RefreshTokenEntity {

	@Id
	@Column(name = "refresh_token_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long refreshTokenId;

	@Column(name = "token")
	private String token;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX", timezone = "America/Bogota")
	@Column(name = "expiry_time")
	private OffsetDateTime expiryTime;

	@OneToOne()
	@JoinColumn(name = "user_id")
	private UserEntity user;
}
