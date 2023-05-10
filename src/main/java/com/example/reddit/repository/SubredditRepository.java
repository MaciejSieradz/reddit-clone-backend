package com.example.reddit.repository;

import com.example.reddit.model.Subreddit;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** SubredditRepository */
@Repository
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {

  Optional<Subreddit> findByName(String subredditName);
}
