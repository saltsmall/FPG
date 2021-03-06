package pl.krzysztofskul;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.club.Club;
import pl.krzysztofskul.club.ClubService;
import pl.krzysztofskul.game.Game;
import pl.krzysztofskul.game.GameService;
import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.PersonService;

@Service
@Transactional
public class HomePageService {
	
	/** p. */
	private PersonService personService;
	private ClubService clubService;
	private GameService gameService;
	
	/** c. */
	@Autowired
	public HomePageService(
			PersonService personService,
			ClubService clubService,
			GameService gameService
			) {
		this.personService = personService;
		this.clubService = clubService;
		this.gameService = gameService;
	}
	
	/** m. */
	public void createPersons() {
	
		for (int i=1; i<=44; i++) {
			Person person = new Person();
			/* main info */
			person.setNameFirst("Firstname0"+i);
			person.setNameLast("Lastname0"+i);
			person.setNameNick(person.getNameFirst()+" "+person.getNameLast());
			person.setPrice(BigDecimal.valueOf(100));
			/* player parameters */
			Random random = new Random();
			person.setGoalkeeping(random.nextInt(998)+1);
			person.setShooting(random.nextInt(998)+1);
			/* save to db */
			personService.save(person);
		}
		
		for (int i=100; i<=110; i++) {
			Person person = new Person();
			/* main info */
			person.setNameFirst("Firstname"+i);
			person.setNameLast("Lastname"+i);
			person.setNameNick(person.getNameFirst()+" "+person.getNameLast());
			person.setPrice(BigDecimal.valueOf(100));
			/* player parameters */
			Random random = new Random();
			person.setGoalkeeping(random.nextInt(998)+1);
			person.setShooting(random.nextInt(998)+1);
			/* save to db */
			personService.save(person);
		}
		
	}
	
	public void createClubs() {
		
		for (int i = 1; i <= 6; i++) {
			Club club = new Club();
			club.setName("Clubname00"+i);
			club.setCity("Cityname");
			club.setCountry("PL");
			club.setShortName("c00"+i);
			club.setFullName("Clubname"+i+" Cityname");
	//		club.setCreated(Date.valueOf("1900-01-01"));
			club.setCreated(LocalDate.of(new Random().nextInt(19)+1901, new Random().nextInt(11)+1, new Random().nextInt(27)+1));
			club.setBudget(BigDecimal.valueOf(1000000.99));
			clubService.save(club);
		}
		
//		Club club002 = new Club();
//		club002.setName("Clubname002");
//		clubService.save(club002);
//		
//		Club club003 = new Club();
//		club003.setName("Clubname003");
//		clubService.save(club003);
//		
//		Club club004 = new Club();
//		club004.setName("Clubname004");
//		clubService.save(club004);
		
	}
	
	public void addPersonsToClub() {
//		List<Club> clubs = clubService.loadAll();
//		
//		int j = 1;
//		for (Club club : clubs) {
//			for (int i = 1; i<=11; i++) {
//				Person person = personService.loadById(Long.valueOf(j));
////				person.setClub(club);
//				personService.save(person);
//				j++;
//			}
//		}
		
		int counter = 0;
		for (int i = 1; i <= 2; i++) {
			Club club = clubService.loadByIdWithPersons(Long.parseLong(String.valueOf(i)));
			for (int j = 1+counter; j <= 11+counter; j++) {
				Person person = personService.loadById(Long.valueOf(j));
				person.setHired(true);
				personService.save(person);
				club.addPerson(person);	
			}	
			counter += 11;
			clubService.save(club);
		}		
	}
	
	public void createGames() {
		Game game;
		/* 1 */
		game = new Game(clubService.loadById(Long.valueOf("1")), clubService.loadById(Long.valueOf("2")));
		game.goalForGuest();
		game.goalForHost();
		game.goalForHost();
		gameService.save(game);
		/* 2 */
		game = new Game(clubService.loadById(Long.valueOf("3")), clubService.loadById(Long.valueOf("4")));
		game.goalForGuest();
		game.goalForGuest();
		game.goalForGuest();
		game.goalForHost();
		game.goalForHost();
		game.goalForHost();
		gameService.save(game);
	}
	
}