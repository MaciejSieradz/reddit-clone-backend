package com.example.reddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.reddit.config.OpenAPIConfiguration;

@SpringBootApplication
@EnableAsync
@Import(OpenAPIConfiguration.class)
public class RedditApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedditApplication.class, args);
  }
}
