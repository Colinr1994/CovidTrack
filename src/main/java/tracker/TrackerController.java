package tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {

	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("") 
	public String submit(
		@RequestParam("email") String email, 
		Model model) {
		model.addAttribute("email", email);
		// Process data (DB call) 
		System.out.println("Run");
		return "success";
	}
	
	@GetMapping("/user")
	public String manager(Model model) {
		return "lookup";
	}


}
