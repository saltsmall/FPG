package pl.krzysztofskul.club;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import pl.krzysztofskul.club.logo.LogoFile;
import pl.krzysztofskul.game.Game;
import pl.krzysztofskul.person.Person;

@Entity
@Table(name = "Clubs")
public class Club {
	
	/** p. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String shortName;
	
	@NotBlank
	private String fullName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LogoFile logo;
	
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate created;
	
	@NotNull
	@DecimalMin(value = "0", inclusive = true)
	private BigDecimal budget;
	
//	@OneToMany(mappedBy = "club")
	@OneToMany
    @JoinTable(
            name="club_persons",
            joinColumns = @JoinColumn(name="club_id"),
            inverseJoinColumns = @JoinColumn(name="person_id")
        )
	private List<Person> persons = new ArrayList<Person>();
	
	@ManyToOne
	private Person coachFirst;
	
	@OneToOne
	private Person goalkeeper;
	@OneToOne
	private Person shooter01;
	@OneToOne
	private Person shooter02;
	@OneToOne
	private Person shooter03;
	@OneToOne
	private Person shooter04;
	@OneToOne
	private Person shooter05;
	
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
	public LogoFile getLogo() {
		return logo;
	}

	public void setLogo(LogoFile logo) {
		this.logo = logo;
	}

	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
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
	public Person getGoalkeeper() {
		return goalkeeper;
	}

	public void setGoalkeeper(Person goalkeeper) {
		this.goalkeeper = goalkeeper;
	}

	public Person getShooter01() {
		return shooter01;
	}

	public void setShooter01(Person shooter01) {
		this.shooter01 = shooter01;
	}

	public Person getShooter02() {
		return shooter02;
	}

	public void setShooter02(Person shooter02) {
		this.shooter02 = shooter02;
	}

	public Person getShooter03() {
		return shooter03;
	}

	public void setShooter03(Person shooter03) {
		this.shooter03 = shooter03;
	}

	public Person getShooter04() {
		return shooter04;
	}

	public void setShooter04(Person shooter04) {
		this.shooter04 = shooter04;
	}

	public Person getShooter05() {
		return shooter05;
	}

	public void setShooter05(Person shooter05) {
		this.shooter05 = shooter05;
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
//		List<Person> persons = this.getPersons();
//		persons.add(person);
//		this.setPersons(persons);
//		this.budget = getBudget().subtract(BigDecimal.valueOf(100));
		this.persons.add(person);
		this.budget = this.getBudget().subtract(person.getPrice());
	}
	public void removePerson(Person person) {
		this.getPersons().remove(person);
	}
}