package pl.krzysztofskul.game;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.krzysztofskul.club.Club;
import pl.krzysztofskul.club.ClubService;

@Controller
@RequestMapping("/games")
public class GameController {
	
	/** p. */
	private GameService gameService;
	private ClubService clubService;
	
	/** c. */
	@Autowired
	public GameController(
			GameService gameService,
			ClubService clubService
	) {
		this.gameService = gameService;
		this.clubService = clubService;
	}
	
	/** g and s */
	
	/** m. */
	@ModelAttribute("allClubs")
	public List<Club> getAllClubs() {
		return clubService.loadAll();
	}
	
	@GetMapping("/all")
	public String gamesAll(Model model) {	
		model.addAttribute("gamesAll", gameService.loadAll());
		return "games/all";
	}
	
	@GetMapping("/randomplay")
	public String randomplay() {
		int clubsNum = clubService.loadAll().size();
		Random random = new Random();
		Long idHost = Integer.toUnsignedLong(random.nextInt(clubsNum)+1);
		Long idGuest = Integer.toUnsignedLong(random.nextInt(clubsNum)+1);
		return "redirect:/games/play/"+idHost+"/"+idGuest;
	}
	
	@GetMapping("/arrange")
	public String arrange(
			Model model
	) {
		Game game = new Game();
		model.addAttribute("game", game);
		return "games/arrange";
	}
	@PostMapping("/arrange")
	public String arrange(
			@ModelAttribute("game") Game game,
			Model model
	) {
		Long idHost = game.getHost().getId();
		Long idGuest = game.getGuest().getId();
		if (idHost == idGuest) {
			String error = "error";
			model.addAttribute("error", error);
			return "redirect:/games/arrange";
		} else {
			String error = null;
			model.addAttribute("error", error);
			return "redirect:/games/play/"+idHost+"/"+idGuest;
		}
	}
	
	@GetMapping("/play/{idHost}/{idGuest}") 
	public String play(
		@PathVariable Long idHost,
		@PathVariable Long idGuest,
		Model model
	) {
		Club clubHost = clubService.loadByIdWithPersons(idHost);
		Club clubGuest = clubService.loadByIdWithPersons(idGuest);
		
		Game game = new Game(clubHost, clubGuest);
		
		model.addAttribute("game", game);
	
		return "games/play";
	}
	
	@PostMapping("/play/save")
	public String playSave(
			@ModelAttribute("game") Game game
	) {
		gameService.save(game);
		return "redirect:/games/all";
	}
	
}