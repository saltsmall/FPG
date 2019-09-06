package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	/** p. */
	private HomePageService homePageService;
	
	/** c. */
	@Autowired
	public HomePageController(HomePageService homePageService) {
		this.homePageService = homePageService;
	}

	
	/** m. */
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/start")
	public String start() {
		homePageService.createPersons();
		homePageService.createClubs();
		homePageService.addPersonsToClub();
		return "index";
	}
	
}