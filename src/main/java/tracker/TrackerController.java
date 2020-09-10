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
	
	@GetMapping("/user")
	public String manager(Model model) {
		return "lookup";
	}
}
