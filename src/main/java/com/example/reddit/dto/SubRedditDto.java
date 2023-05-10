package com.example.reddit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** SubRedditDto */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubRedditDto {

  private Long id;
  private String name;
  private String description;
  private Integer numberOfPosts;
}
