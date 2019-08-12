package com.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;


@SpringBootApplication
@ComponentScan("com.twitter")
public class TwitterApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterApiApplication.class, args);
	}

}
