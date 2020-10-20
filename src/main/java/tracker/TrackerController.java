package tracker;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {
	
	@Autowired
	private TrackerRepository trackerRepository;

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/") 
	public String submit(
		@RequestParam("email") String email, 
		Model model) {
		User user = trackerRepository.findByEmail(email);
		if (user == null) {
			return "fail";
		}
		user.setPassedDate();
	trackerRepository.save(user);
		return "success";
	}
	
	@GetMapping("/manager")
	public String manager(Model model) {		
		return "lookup";
	}
	
	@PostMapping("/manager")
	public String searchManager(
			@RequestParam("email") String email,
			Model model) {
		Iterable<User> users = trackerRepository.findApprovedWithManager(email);
		model.addAttribute("users", users);
		return "results";
	}
}
