package tracker;

import org.springframework.stereotype.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface TrackerRepository extends CrudRepository<User, String> {
	User findByEmail(String email);
	List<User> findAll();
	
	// Manager Access 
	List<User> findByManager(String manager);

	//SELECT TIMESTAMPDIFF(HOUR, passed_date,NOW() ) FROM users WHERE email='test@email.com';
	
	@Query(nativeQuery = true, value="SELECT * FROM users WHERE manager = ?1 AND TIME_TO_SEC(TIMEDIFF( NOW(),passed_date)) > 86400")
    List<User> findApprovedWithManager(String manager);
	
					
	// Insert User 
	//@Modifying
	//@Query(value = "INSERT INTO users(email, fName, lName, manager) VALUES ("test@email.com","first","last","manager@email.com")", nativeQuery = true)
	//void insertUser();
}

	
