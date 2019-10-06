package pl.krzysztofskul.club;

import java.awt.Image;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pl.krzysztofskul.club.logo.LogoFile;
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
	
	@PostMapping("/save")
	public String save (
		@ModelAttribute("club") @Valid Club club, 
		BindingResult result
	) {
		if(result.hasErrors()) {
			return "/clubs/new";
		}
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
	
	@GetMapping("/{clubId}/setLogo")
	public String setLogo(
		@PathVariable("clubId") Long clubId,
		Model model
	) {
		model.addAttribute("club", clubService.loadById(clubId));
		return "clubs/setLogo";
	}
	@PostMapping("/setLogo")
	public String setLogo(
			@RequestParam("file") MultipartFile file,
			Model model,
			@ModelAttribute("club") Club club
	) {
		Club clubEdited = clubService.loadById(club.getId());
		clubEdited.setLogo(logoFileService.saveLogoFile(file));
		clubService.save(clubEdited);
//		logoFileService.saveLogoFile(file);
//		Club clubEdited = clubService.loadById(club.getId());
//		clubEdited.setLogo(logoFileService.findById(Long.valueOf(club.getLogo().getId())));
//		clubService.save(clubEdited);
		return "redirect:/clubs/all";
	}
	@RequestMapping(value = "/logo/{clubId}")
	@ResponseBody
	public byte[] logo(@PathVariable Long clubId)  {
//	  return logoFileService.findById(clubId).getData();
	  return logoFileService.getFileByClub(clubService.loadById(clubId)).getData();
	}

	@GetMapping("/{id}/hireNewPersons")
	public String hireNewPersons(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("club", clubService.loadById(id));
		model.addAttribute("personsForHire", personService.loadAllForHire());
//		model.addAttribute("personsForHire", personService.loadAll());
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
			Person person = personService.loadById(Long.parseLong(s));
			person.setHired(true);
			personService.save(person);
			club.addPerson(person);
			
//			Person person = personService.loadById(Long.parseLong(s));
//			person.setClub(club);
//			personService.save(person);
		}
		clubService.save(club);
		return "redirect:/clubs/"+clubId+"/details";
	}
	
}