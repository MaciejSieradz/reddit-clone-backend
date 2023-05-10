package com.example.reddit.service;

import com.example.reddit.dto.CommentsDto;
import com.example.reddit.exceptions.PostNotFoundException;
import com.example.reddit.mapper.CommentMapper;
import com.example.reddit.model.Comment;
import com.example.reddit.model.NotificationEmail;
import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.repository.CommentRepository;
import com.example.reddit.repository.PostRepository;
import com.example.reddit.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** CommentService */
@Service
@AllArgsConstructor
public class CommentService {

  private static final String POST_URL = "";
  private final PostRepository postRepository;
  private final UserRepository userRepository;
  private final AuthService authService;
  private final CommentMapper commentMapper;
  private final CommentRepository commentRepository;
  private final MailContentBuilder mailContentBuilder;
  private final MailService mailService;

  public void save(CommentsDto commentsDto) {
    Post post =
        postRepository
            .findById(commentsDto.getPostId())
            .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));

    Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
    commentRepository.save(comment);

    String message =
        mailContentBuilder.build(
            post.getUser().getUsername() + " posted a comment on your post." + POST_URL);
    sendCommentNotification(message, post.getUser());
  }

  private void sendCommentNotification(String message, User user) {
    mailService.sendMail(
        new NotificationEmail(
            user.getUsername() + "commented on your post", user.getEmail(), message));
  }

  public List<CommentsDto> getAllCommentsForPost(Long postId) {
    Post post =
        postRepository
            .findById(postId)
            .orElseThrow(() -> new PostNotFoundException(postId.toString()));

    return commentRepository.findByPost(post).stream()
        .map(commentMapper::mapToDto)
        .collect(Collectors.toList());
  }

  public List<CommentsDto> getAllCommentsForUser(String username) {
    User user =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));

    return commentRepository.findAllByUser(user).stream()
        .map(commentMapper::mapToDto)
        .collect(Collectors.toList());
  }
}
