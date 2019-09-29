package pl.krzysztofskul.person;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pl.krzysztofskul.club.Club;

@Entity
@Table(name = "Persons")
public class Person {
	
	/** param. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameFirst;
	private String nameLast;
	private String nameNick;
	
	private LocalDate dateOfBirth;
	
	private int coaching;
	private int goalkeeping;
	private int shooting;
	
	@ManyToOne
	private Club club;
	
	private BigDecimal price;
	
	@OneToOne(mappedBy="coachFirst")
	private Club clubCoach;
	
	/** constr. */
	
	/** g and s */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameFirst() {
		return nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	public String getNameLast() {
		return nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	public String getNameNick() {
		return nameNick;
	}

	public void setNameNick(String nameNick) {
		this.nameNick = nameNick;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCoaching() {
		return coaching;
	}

	public void setCoaching(int coaching) {
		this.coaching = coaching;
	}

	public int getGoalkeeping() {
		return goalkeeping;
	}

	public void setGoalkeeping(int goalkeeping) {
		this.goalkeeping = goalkeeping;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Club getClubCoach() {
		return clubCoach;
	}

	public void setClubCoach(Club clubCoach) {
		this.clubCoach = clubCoach;
	}
	
	/** methods */
	
}