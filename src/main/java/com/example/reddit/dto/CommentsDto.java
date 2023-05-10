package com.example.reddit.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** CommentsDto */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {

  private Long id;
  private Long postId;
  private Instant createdDate;

  @NotBlank private String text;
  private String userName;
}
