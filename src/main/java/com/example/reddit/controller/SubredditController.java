package com.example.reddit.controller;

import com.example.reddit.dto.SubRedditDto;
import com.example.reddit.service.SubredditService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** SubredditController */
@RestController
@RequestMapping("/api/subreddit")
@AllArgsConstructor
@Slf4j
public class SubredditController {

  private final SubredditService subredditService;

  @PostMapping(consumes = "application/json")
  public ResponseEntity<SubRedditDto> createSubreddit(@RequestBody SubRedditDto subRedditDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(subredditService.save(subRedditDto));
  }

  @GetMapping
  public ResponseEntity<List<SubRedditDto>> getAllSUbreddits() {
    return ResponseEntity.status(HttpStatus.OK).body(subredditService.getAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<SubRedditDto> getSubreddi(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(subredditService.getSubreddit(id));
  }
}
