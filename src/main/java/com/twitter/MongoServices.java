package com.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MongoServices {

	
	@Autowired
	private TwitterRepo mongo;
	
	
	public String saveUser(TwitterModel username) {		
		mongo.save(username);
		return "Added user: " + username.getUsername();
	}
	
	
	public TwitterModel getUser(String username) {
		return mongo.findByusername(username);
	}
	
	
	public List<TwitterModel> getTwitter(){
		return mongo.findAll();
	}
	
	
	public String deleteUser(String username) {
		System.out.println(getUser(username).getObjectId());
		mongo.deleteById(getUser(username).getObjectId());
		return "User deleted with username: " + username;
	}
	
	public String updateTwitter(TwitterModel username) {
		mongo.findByusername(username);
		mongo.save(username);
		return "Username updated " + username;
	}
}
