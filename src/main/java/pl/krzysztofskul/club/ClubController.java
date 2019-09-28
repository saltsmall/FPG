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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.krzysztofskul.club.logo.LogoFileService;

@Controller
@RequestMapping("/clubs")
public class ClubController {

	/**
	 *  params. 
	 **/
	private ClubService clubeService;
	private LogoFileService logoFileService;
	
	/** 
	 * constr. 
	 **/
	@Autowired
	public ClubController(
			ClubService clubeService,
			LogoFileService logoFileService
	) {
		this.clubeService = clubeService;
		this.logoFileService = logoFileService;
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
	
	@PostMapping("/update") // TODO: validation
	public String update (
		@ModelAttribute("club") Club club
	) {
		clubeService.save(club);
		return "redirect:/clubs/"+club.getId()+"/details";
	}
	
	@GetMapping("/{id}/setLogo")
	public String setLogo(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubeService.loadById(id));
		return "clubs/setLogo";
	}
	@PostMapping("/setLogo")
	public String setLogo(
			@RequestParam("file") MultipartFile file,
			Model model,
			@ModelAttribute("club") Club club
	) {
		logoFileService.saveLogoFile(file);
		Club clubEdited = clubeService.loadById(club.getId());
		clubEdited.setLogo(logoFileService.findById(Long.valueOf("1")));
		clubeService.save(clubEdited);
		return "clubs/all";
	}
	
	/*** m. CRUD delete */
	
}