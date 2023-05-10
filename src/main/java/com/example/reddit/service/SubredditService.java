package com.example.reddit.service;

import static java.util.stream.Collectors.toList;

import com.example.reddit.dto.SubRedditDto;
import com.example.reddit.exceptions.SpringRedditException;
import com.example.reddit.mapper.SubredditMapper;
import com.example.reddit.model.Subreddit;
import com.example.reddit.repository.SubredditRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** SubredditService */
@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

  private final SubredditRepository subredditRepository;
  private final SubredditMapper subredditMapper;

  @Transactional
  public SubRedditDto save(SubRedditDto subRedditDto) {
    Subreddit subreddit = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subRedditDto));
    subRedditDto.setId(subreddit.getId());
    return subRedditDto;
  }

  @Transactional
  public List<SubRedditDto> getAll() {
    return subredditRepository.findAll().stream()
        .map(subredditMapper::mapSubredditToDto)
        .collect(toList());
  }

  public SubRedditDto getSubreddit(Long id) {
    Subreddit subreddit =
        subredditRepository
            .findById(id)
            .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
    return subredditMapper.mapSubredditToDto(subreddit);
  }
}
