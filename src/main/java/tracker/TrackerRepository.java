package tracker;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


//WIP!!
@Repository
public interface TrackerRepository extends CrudRepository<User, String> {
	User findByEmail(String email);
	List<User> findAll();
	
	
	//Create method to set specific user "passed" value to true.
}
