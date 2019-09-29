package pl.krzysztofskul.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/forHire")
	public String forHire(
		Model model
	) {
		List<Person> persons = personService.loadAllForHire();
		model.addAttribute("persons", persons);
		return "persons/forHire";
	}
	
}
