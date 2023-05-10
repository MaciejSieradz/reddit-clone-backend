package com.example.reddit.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** RefreshTokenRequest */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequest {

  @NotBlank private String refreshToken;
  private String username;
}