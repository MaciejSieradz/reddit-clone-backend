package com.example.reddit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** NotificationEmail */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEmail {

  private String subject;
  private String recipient;
  private String body;
}
