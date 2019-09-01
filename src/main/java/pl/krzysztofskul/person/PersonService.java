package pl.krzysztofskul.person;

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
	/** m. CRUD update */
	/** m. CRUD delete */
	
}