package pl.krzysztofskul.person;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PersonService {
	
	/** p. */
	private PersonRepository personRepository;
	
	/** c. */
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	/** m. */
	
	/** m. CRUD create */
	public void save(Person person) {
		personRepository.save(person);
	}
	/** m. CRUD read */
	public List<Person> loadAll() {
		return personRepository.findAll();
	}
	
	public List<Person> loadAllForHire() {
//		return personRepository.findAllForHire();
		return personRepository.findByIsHired(false);
	}
	
	public Person loadById(Long id) {
		return personRepository.findById(id).get();
	}
	
	/** m. CRUD update */
	/** m. CRUD delete */
	
}