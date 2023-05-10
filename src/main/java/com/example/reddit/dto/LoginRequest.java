package com.example.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** LoginRequest */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

  private String username;
  private String password;
}
