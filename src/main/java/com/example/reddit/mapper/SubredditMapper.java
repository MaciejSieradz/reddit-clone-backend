package com.example.reddit.mapper;

import com.example.reddit.dto.SubRedditDto;
import com.example.reddit.model.Post;
import com.example.reddit.model.Subreddit;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** SubredditMapper */
@Mapper(componentModel = "spring")
public interface SubredditMapper {

  @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
  SubRedditDto mapSubredditToDto(Subreddit subreddit);

  default Integer mapPosts(List<Post> numberOfPosts) {
    return numberOfPosts.size();
  }

  @InheritInverseConfiguration
  @Mapping(target = "posts", ignore = true)
  Subreddit mapDtoToSubreddit(SubRedditDto subRedditDto);
}
