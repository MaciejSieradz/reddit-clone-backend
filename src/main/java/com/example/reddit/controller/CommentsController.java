package com.example.reddit.controller;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.service.CommentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** CommentsController */
@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentsController {

  private final CommentService commentService;

  @PostMapping
  public ResponseEntity<Void> createComment(@RequestBody CommentsDto commentsDto) {
    commentService.save(commentsDto);

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(params = "postId")
  public ResponseEntity<List<CommentsDto>> getAllCommentsForPost(@RequestParam Long postId) {
    return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllCommentsForPost(postId));
  }

  @GetMapping(params = "userName")
  public ResponseEntity<List<CommentsDto>> getAllCommentsForUser(@RequestParam String userName) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(commentService.getAllCommentsForUser(userName));
  }
}
