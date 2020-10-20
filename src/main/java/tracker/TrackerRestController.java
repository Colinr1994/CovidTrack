package tracker;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackerRestController {
	
	private final TrackerRepository repository;
	
	TrackerRestController(TrackerRepository repository) {
		this.repository=repository;
	}

	@GetMapping("/api/manager/{email}")
	public List<User> search(@PathVariable String email) {
		return repository.findApprovedWithManager(email);
	}

	//Not sure what type HttpResponse is
	@GetMapping("/api/{email}")
	public String put(@PathVariable String email) {
		User user = repository.findByEmail(email);
		if (user == null) {
			return "NOT FOUND";
		} else {
			user.setPassedDate();
			repository.save(user);
			return "SUCCESS";
		}
	}
}
