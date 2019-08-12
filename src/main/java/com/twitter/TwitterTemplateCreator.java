package com.twitter;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class TwitterTemplateCreator {
	
//	@Autowired
//	MongoServices ms;
	
	
	public Twitter getTwitter() {
		
		String consumerKey = ""; //applications API key
		String consumerSecret = ""; //applications secret key
		String accessToken = ""; //access token granted after OAuth 
		String accessTokenSecret = ""; //access token secret granted after OAuth 
		
		//Twitter twitter  = new TwitterTemplate("${twitter.api}", "${twitter.secretApi}", accessToken, accessTokenSecret);
		Twitter twitter  = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
//		Twitter twitter =  new TwitterTemplate();
//		Connection<Twitter> connection = connectionRepository.findPrimaryConnection(Twitter.class);
//		Twitter twitter = connection != null ? connection.getApi() : new TwitterConfig();
		
		return twitter;
		
	}
	
	
	
	
}
