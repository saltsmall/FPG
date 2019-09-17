package pl.krzysztofskul.club;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@GetMapping("/new") // TODO
	public String newClubForm(
		Model model
	) {
		model.addAttribute("club", new Club());
		return "clubs/new";
	}
	
	@PostMapping("/save") // TODO
	public String save () {
		return "clubs/all";
	}
	
	/*** m. CRUD read */
	@GetMapping("/all")	// TODO
	public String all() {
		return "clubs/all";
	}

	/*** m. CRUD delete */
	@GetMapping("/delete") // TODO
	public String delete () {
		return "clubs/delete";
	}
	
}