package tracker;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


//WIP!!
@Repository
public interface TrackerRepository extends CrudRepository<User, String> {
	User findByEmail(String email);
	List<User> findAll();
	
	
	//Test
	@Modifying
	@Query(value = "UPDATE User u SET u.passed = TRUE WHERE u.email =?1", nativeQuery = true)
	void updatePassed(String email);
}
	
