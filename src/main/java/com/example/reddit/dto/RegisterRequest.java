package com.example.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** RegisterRequest */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String email;
  private String username;
  private String password;
}
