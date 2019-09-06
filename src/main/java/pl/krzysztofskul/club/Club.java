package pl.krzysztofskul.club;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.krzysztofskul.person.Person;

@Entity
@Table(name = "Clubs")
public class Club {
	
	/** p. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "club")
	private List<Person> persons = new ArrayList<Person>();
	
	/** c. */
	
	/** g and s */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	/** m. */
	public void addPerson(Person person) {
		this.getPersons().add(person);
		System.out.println("new person to the club added: "+person.getNameNick());
	}
	public void removePerson(Person person) {
		this.getPersons().remove(person);
	}
}