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
		if (user == null) {
			return "fail";
		}
		user.setPassed(true);
		return "success";
	}
	
	@GetMapping("/manager")
	public String manager(Model model) {
		String email = new String();
		model.addAttribute("email",email);
		
		
		return "lookup";
	}
	
	@PostMapping("/manager")
	public String searchManager(Model model) {
		//Iterable<User> managedUsers = trackerRepository.findByManager(manager);
		//trackerRepository.insertUser();
		return "index";
	}


}
