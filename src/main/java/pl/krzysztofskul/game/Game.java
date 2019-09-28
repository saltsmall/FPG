package pl.krzysztofskul.game;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import pl.krzysztofskul.club.Club;

@Entity
@Table(name = "Games")
public class Game {
	
	/** p. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime date;
	
	@ManyToOne
	private Club host;
	
	@ManyToOne
	private Club guest;
	
	private int goalsHost;
	private int goalsGuest;
	
	/** c. */
	public Game() {
		
	}
	
	public Game(Club host, Club guest) {
		this.host = host;
		this.guest = guest;
		this.goalsHost = 0;
		this.goalsGuest = 0;
	}
	
	/** g and s */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Club getHost() {
		return host;
	}
	
	public void setHost(Club host) {
		this.host = host;
	}
	public Club getGuest() {
		return guest;
	}
	public void setGuest(Club guest) {
		this.guest = guest;
	}
	public int getGoalsHost() {
		return goalsHost;
	}
	public void setGoalsHost(int goalsHost) {
		this.goalsHost = goalsHost;
	}
	public int getGoalsGuest() {
		return goalsGuest;
	}
	public void setGoalsGuest(int goalsGuest) {
		this.goalsGuest = goalsGuest;
	}
	
	/** m. */
	public void goalForHost() {
		this.goalsHost++;
	}
	
	public void goalForGuest() {
		this.goalsGuest++;
	}
	
	@PrePersist
	public void prePersist() {
		setDate(LocalDateTime.now());
	}

}
