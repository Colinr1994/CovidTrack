package tracker;

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

	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("") 
	public String submit(
		@RequestParam("email") String email, 
		Model model) {
		//model.addAttribute("email", email);
		// Process data (DB call) 
		User user = trackerRepository.findByEmail(email);
		user.setPassed(false);
		trackerRepository.save(user);
		return "success";
	}
	
	@GetMapping("/user")
	public String manager(Model model) {
		Iterable<User> users = trackerRepository.findAll();
		return users.toString();
	}
	
	@PostMapping("/user")
	public String searchManager(Model model) {
		//Iterable<User> managedUsers = trackerRepository.findByManager(manager);
		//trackerRepository.insertUser();
		return "index";
	}


}
