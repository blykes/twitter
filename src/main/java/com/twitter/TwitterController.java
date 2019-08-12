package com.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //
@RequestMapping("/user")
public class TwitterController {
	
//	@Autowired
//	TwitterService twitterService; //creates the service
	
	@Autowired
	TwitterTemplateCreator tp;	
	
	@Autowired
	MongoServices mongoService;
	
	
	@GetMapping("/twitter/{username}")
	public ResponseEntity<?> getUsername(@PathVariable("username") String userName) {
//		TwitterProfile candidate = twitterService.getByUsername(username);
		TwitterModel tm = mongoService.getUser(userName);
		
		return new ResponseEntity(tm, HttpStatus.OK);
	}
	
	@PostMapping("/twitter")
	public ResponseEntity<?> addTwitter(@RequestBody TwitterModel username) {
		System.out.println(username.getUsername());
		Twitter twitter = tp.getTwitter();
		
		TwitterProfile twitterProfile = twitter.userOperations().getUserProfile(username.getUsername());
//		System.out.println("User ID: " + twitterProfile.getScreenName());
//		System.out.println("Friends: " + twitterProfile.getFriendsCount());
//		System.out.println("Followers: " + twitterProfile.getFollowersCount());
//		System.out.println("Tweets: " + twitterProfile.getStatusesCount());
//		System.out.println("Bio: " + twitterProfile.getDescription());
//		System.out.println("Location: " + twitterProfile.getLocation());
//		System.out.println("Likes: " + twitterProfile.getFavoritesCount());
//		System.out.println(twitterProfile.getCreatedDate());
		TwitterModel tm = new TwitterModel(twitterProfile.getName(), twitterProfile.getId(), 
				twitterProfile.getFollowersCount(), twitterProfile.getFriendsCount(), twitterProfile.getFavoritesCount(), 
				twitterProfile.getScreenName(), twitterProfile.getDescription(), 
				twitterProfile.getLocation(), twitterProfile.getStatusesCount(), twitterProfile.getProfileImageUrl());
		System.out.println(tm.toString());
		try {
		mongoService.saveUser(tm);
		} catch (Exception e) {
			return new ResponseEntity(tm, HttpStatus.SERVICE_UNAVAILABLE);
		}

		return new ResponseEntity(tm, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/twitter/{username}")
	public ResponseEntity<?> deleteUser (@PathVariable String username) {
		System.out.println(mongoService.getUser(username).toString());
		try {
			mongoService.deleteUser(username);
		return new ResponseEntity("out try", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("out catch", HttpStatus.SERVICE_UNAVAILABLE);
		}
				
	}
	
	@PutMapping("/twitter")
	public ResponseEntity<?> updateTwitter(@RequestBody TwitterModel username) {
		
		Twitter twitter = tp.getTwitter();
				
		TwitterProfile twitterProfile = twitter.userOperations().getUserProfile(username.getUsername());
//		System.out.println("User ID: " + twitterProfile.getScreenName());
//		System.out.println("Friends: " + twitterProfile.getFriendsCount());
//		System.out.println("Followers: " + twitterProfile.getFollowersCount());
//		System.out.println("Tweets: " + twitterProfile.getStatusesCount());
//		System.out.println("Bio: " + twitterProfile.getDescription());
//		System.out.println("Location: " + twitterProfile.getLocation());
//		System.out.println("Likes: " + twitterProfile.getFavoritesCount());
//		System.out.println(twitterProfile.getCreatedDate());
		
		TwitterModel tm = new TwitterModel(twitterProfile.getScreenName(), twitterProfile.getId(),twitterProfile.getFollowersCount(), 
				twitterProfile.getFriendsCount(), 
				twitterProfile.getFavoritesCount(), twitterProfile.getName(), twitterProfile.getDescription(), 
				twitterProfile.getLocation(), twitterProfile.getStatusesCount(), twitterProfile.getProfileImageUrl());
		System.out.println(tm.toString());
		System.out.println((twitterProfile.getName()));
		System.out.println();
		try {
			if (!mongoService.getUser(username.getUsername()).equals(null)) {
				System.out.println("In delete if");
				mongoService.deleteUser(tm.getUsername());
				mongoService.saveUser(tm);
				
	
			} else {
				System.out.println("in delete else");
				return new ResponseEntity(tm, HttpStatus.SERVICE_UNAVAILABLE);
			}
				
			} catch (Exception e) {
				System.out.println("in delete catch");
				return new ResponseEntity(tm, HttpStatus.SERVICE_UNAVAILABLE);
			}
			System.out.println("created");
			return new ResponseEntity(tm, HttpStatus.CREATED);
	}
	
	//for testing purposes
//	@GetMapping("/twitter")
//	public ResponseEntity<?> testTwitter(@RequestBody TwitterModel username) {
//		System.out.println(username.getUsername());
//		Twitter twitter = tp.getTwitter();
//		
//		TwitterProfile twitterProfile = twitter.userOperations().getUserProfile(username.getUsername());
////		System.out.println("User ID: " + twitterProfile.getScreenName()); //@name
////		System.out.println("Friends: " + twitterProfile.getFriendsCount()); //following
////		System.out.println("Followers: " + twitterProfile.getFollowersCount()); //Followers
////		System.out.println("Tweets: " + twitterProfile.getStatusesCount()); //Tweet count
////		System.out.println("Bio: " + twitterProfile.getDescription()); //bio
////		System.out.println("Location: " + twitterProfile.getLocation()); //location
////		System.out.println("Likes: " + twitterProfile.getFavoritesCount()); //favorites/likes
////		System.out.println("Created: "+ twitterProfile.getCreatedDate()); //account created
////		System.out.println(("Profile name: " + twitterProfile.getName())); //Name displayed on profile
////		System.out.println("Pic: " + twitterProfile.getProfileImageUrl()); //profile pic
////		System.out.println("I dont know what this is: " + username.getUsername());
//		TwitterModel tm = new TwitterModel(twitterProfile.getName(), twitterProfile.getId(), 
//				twitterProfile.getFollowersCount(), twitterProfile.getFriendsCount(), twitterProfile.getFavoritesCount(), 
//				twitterProfile.getScreenName(), twitterProfile.getDescription(), 
//				twitterProfile.getLocation(), twitterProfile.getStatusesCount(), twitterProfile.getProfileImageUrl());
//		System.out.println(tm.toString());
//		try {
//		//mongoService.saveUser(tm);
//		} catch (Exception e) {
//			return new ResponseEntity(tm, HttpStatus.SERVICE_UNAVAILABLE);
//		}
////
//		return new ResponseEntity(tm, HttpStatus.CREATED);
//		
//	}

}
