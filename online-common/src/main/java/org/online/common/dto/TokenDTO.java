package org.online.common.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TokenDTO {

    private String accessToken;

    private String refreshToken;

    private LocalDateTime expiryDate;
}
