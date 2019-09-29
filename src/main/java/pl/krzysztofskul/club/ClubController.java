package pl.krzysztofskul.club;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.PersonService;

@Controller
@RequestMapping("/clubs")
public class ClubController {

	/**
	 *  params. 
	 **/
	private ClubService clubService;
	private LogoFileService logoFileService;
	private PersonService personService;
	
	/** 
	 * constr. 
	 **/
	@Autowired
	public ClubController(
			ClubService clubeService,
			LogoFileService logoFileService,
			PersonService personService
	) {
		this.clubService = clubeService;
		this.logoFileService = logoFileService;
		this.personService = personService;
	}
	
	/**
	 *  methods 
	**/
	
	@ModelAttribute("clubsAll")
	public String getAllClubs(
			Model model
	) {
		model.addAttribute("clubsAll", clubService.loadAllWithPersons());
		return "clubs/all";
	}
	
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
		clubService.save(club);
		return "redirect:/clubs/all";
	}
	
	@GetMapping("/all")
	public String all() {
		return "clubs/all";
	}
	
	@GetMapping("/{id}/details")
	public String clubDetails(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubService.loadByIdWithPersons(id));
		return "clubs/details";
	}

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
		model.addAttribute("club", clubService.loadByIdWithPersons(id));
		return "clubs/edit";
	}
	
	@PostMapping("/update") // TODO: validation
	public String update (
		@ModelAttribute("club") Club club
	) {
		clubService.save(club);
		return "redirect:/clubs/"+club.getId()+"/details";
	}
	
	@GetMapping("/{id}/setLogo")
	public String setLogo(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubService.loadById(id));
		return "clubs/setLogo";
	}
	@PostMapping("/setLogo")
	public String setLogo(
			@RequestParam("file") MultipartFile file,
			Model model,
			@ModelAttribute("club") Club club
	) {
		logoFileService.saveLogoFile(file);
		Club clubEdited = clubService.loadById(club.getId());
		clubEdited.setLogo(logoFileService.findById(Long.valueOf("1")));
		clubService.save(clubEdited);
		return "clubs/all";
	}

	@GetMapping("/{id}/hireNewPersons")
	public String hireNewPersons(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubService.loadById(id));
		model.addAttribute("personsForHire", personService.loadAllForHire());
		return "clubs/hireNewPersons";
	}
	@PostMapping("/hireNewPersons")
	public String hireNewPerson(
		HttpServletRequest request
	) {
		Long clubId = Long.parseLong(request.getParameter("clubId"));
		Club club = clubService.loadByIdWithPersons(clubId);
		String[] personsForHire = request.getParameterValues("personsForHire");
		for (String s : personsForHire) {
//			club.addPerson(personService.loadById(Long.parseLong(s)));
//			clubService.save(club);
			Person person = personService.loadById(Long.parseLong(s));
			person.setClub(club);
			personService.save(person);
		}
		
		return "redirect:/clubs/"+clubId+"/details";
	}
	
}