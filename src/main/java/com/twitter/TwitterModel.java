package com.twitter;

import java.util.Date;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="twitter")
public class TwitterModel {
	
	
	private long userid; //twitter user id number
	@Indexed
	@UniqueElements
	private String username; 	//Twitter @Name
	private String profilename; //Profile name
	private String bio; 		//bio 
	private String location;	//location
	@Id
	private String objectId;	//Mongo document ID
	private int followers;		//followers count
	private int likes;			//Tweets liked count
	private int following;		//Following count. Twitter API calls this "friends"
	private int tweets;			//Tweet count
	private String profilePic; 	//profile pic URL
	
	@CreatedDate
	private Date date;
	
	public TwitterModel() {
		super();
	}
	
	public TwitterModel(String profilename, long userid, int followers, int following, int likes, String username, String bio, String location, int tweets, String profilePic) {
		super();
		this.userid = userid;
		this.followers = followers;
		this.following = following;
		this.likes = likes;
		this.username = username;
		this.profilename = profilename;
		this.bio = bio;
		this.location = location;
		this.tweets = tweets;
		this.profilePic = profilePic;
	}
	public long getUser() {
		return userid;
	}
	public void setUser(long userid) {
		this.userid = userid;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTweets() {
		return tweets;
	}

	public void setTweets(int tweets) {
		this.tweets = tweets;
	}

	public String getTwitterName() {
		return profilename;
	}

	public void setTwitterName(String twitterName) {
		this.profilename = profilename;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@Override
	public String toString() {
		return "TwitterModel [userid=" + userid + ", profilename=" + profilename + ", username=" + username + ", bio="
				+ bio + ", location=" + location + ", objectId=" + objectId + ", followers=" + followers + ", likes="
				+ likes + ", following=" + following + ", tweets=" + tweets + ", profilePic=" + profilePic + "]";
	}

	

}
