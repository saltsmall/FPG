package pl.krzysztofskul.club;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pl.krzysztofskul.game.Game;
import pl.krzysztofskul.person.Person;

@Entity
@Table(name = "Clubs")
public class Club {
	
	/** p. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String city;
	private String country;
	
	private String shortName;
	private String fullName;
	
	private Date created;
	
	private BigDecimal budget;
	
	@OneToMany(mappedBy = "club")
	private List<Person> persons = new ArrayList<Person>();
	
	@ManyToOne
	private Person coachFirst;
	
//	private Person goalkeeper;
//	private Person shooter01;
//	private Person shooter02;
//	private Person shooter03;
//	private Person shooter04;
//	private Person shooter05;
	
	@OneToMany(mappedBy = "host")
	private List<Game> gamesAsHost = new ArrayList<Game>();
	
	@OneToMany(mappedBy = "guest")
	private List<Game> gamesAsGuest = new ArrayList<Game>();
	
	/** c. */
	public Club() {
		this.budget = BigDecimal.valueOf(0);
	}
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public Person getCoachFirst() {
		return coachFirst;
	}
	public void setCoachFirst(Person coachFirst) {
		this.coachFirst = coachFirst;
	}
	public List<Game> getGamesAsHost() {
		return gamesAsHost;
	}
	public void setGamesAsHost(List<Game> gamesAsHost) {
		this.gamesAsHost = gamesAsHost;
	}
	public List<Game> getGamesAsGuest() {
		return gamesAsGuest;
	}
	public void setGamesAsGuest(List<Game> gamesAsGuest) {
		this.gamesAsGuest = gamesAsGuest;
	}
	
	/** m. */
	public void addPerson(Person person) {
		this.getPersons().add(person);
	}
	public void removePerson(Person person) {
		this.getPersons().remove(person);
	}
}