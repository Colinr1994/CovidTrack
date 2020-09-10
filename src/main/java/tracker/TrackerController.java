package tracker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrackerController {

	@GetMapping("")
	public String index(Model model) {
		return "index";
	}

	@PostMapping("") // Need to add dependencies. 
	public String submit(
		@ResquestParam("fname) String fName,
		@RequestParam("lname) String lName,
		// Request Date? Alternative: pull sys time 
		Model model) {
		model.addAttribute("fname", fName);
		model.addAttribute("lName", lName);
		// Process data (DB call) 
		//return "success";
	}
	
	@GetMapping("/user")
	public String manager(Model model) {
		return "lookup";
	}


}
