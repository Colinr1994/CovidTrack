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
	
	// Manager Access 
	List<User> findByManager(String manager);

	// Insert User 
	//@Modifying
	//@Query(value = "INSERT INTO users(email, fName, lName, manager, passed) VALUES ("test@email.com","first","last","manny manager", TRUE)", nativeQuery = true)
	//void insertUser();
}

	
