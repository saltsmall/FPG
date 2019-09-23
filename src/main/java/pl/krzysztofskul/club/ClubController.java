package pl.krzysztofskul.club;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clubs")
public class ClubController {

	/**
	 *  params. 
	 **/
	private ClubService clubeService;
	
	/** 
	 * constr. 
	 **/
	@Autowired
	public ClubController(ClubService clubeService) {
		this.clubeService = clubeService;
	}
	
	/**
	 *  methods 
	**/
	
	/*** m. ModelAttributes */
	@ModelAttribute("clubsAll")
	public String getAllClubs(
			Model model
	) {
		model.addAttribute("clubsAll", clubeService.loadAllWithPersons());
		return "clubs/all";
	}
	
	/*** m. CRUD create */
	@GetMapping("/new")
	public String newClubForm(
		Model model
	) {
		model.addAttribute("club", new Club());
		return "clubs/new";
	}
	
	@PostMapping("/save") // TODO: validation
	public String save (
		@ModelAttribute("club") Club club
	) {
		clubeService.save(club);
		return "redirect:/clubs/all";
	}
	
	/*** m. CRUD read */
	@GetMapping("/all")
	public String all() {
		return "clubs/all";
	}
	
	@GetMapping("/{id}/details")
	public String clubDetails(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubeService.loadByIdWithPersons(id));
		return "clubs/details";
	}

	/*** m. CRUD update */
	/*
	 * @GetMapping("/{id}/editPersonsList") // TODO public String editPersonsList(
	 * 
	 * @PathVariable("id") Long id, Model model ) { Club club =
	 * clubeService.loadByIdWithPersons(id); model.addAttribute("club", club);
	 * return "clubs/"+id+"/editPersonsList"; }
	 */
	
	@GetMapping("/{id}/edit")
	public String edit(
			@PathVariable("id") Long id,
			Model model
	) {
		model.addAttribute("club", clubeService.loadByIdWithPersons(id));
		return "clubs/edit";
	}
	
	/*** m. CRUD delete */
	@GetMapping("/delete") // TODO
	public String delete () {
		return "clubs/delete";
	}
	
}