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
	
	@GetMapping({"/", "/home"})
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/startDB")
	public String start() {
		homePageService.createPersons();
		homePageService.createClubs();
		homePageService.addPersonsToClub();
		homePageService.createGames();
		return "index";
	}
	
}