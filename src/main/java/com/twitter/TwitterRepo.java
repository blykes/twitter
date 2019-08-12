/* sets up the repository for managing the Mongo connection and database interactions 
 * 
 */

package com.twitter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.twitter.TwitterModel;

@Repository
public interface TwitterRepo extends MongoRepository<TwitterModel, String> {
	//Optional<TwitterModel> findById(String userid);
	public TwitterModel findByusername (String username);
	public TwitterModel findByusername (TwitterModel username);
}
