package pl.krzysztofskul;

import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.krzysztofskul.club.Club;
import pl.krzysztofskul.club.ClubService;
import pl.krzysztofskul.person.Person;
import pl.krzysztofskul.person.PersonService;

@Service
@Transactional
public class HomePageService {
	
	/** p. */
	private PersonService personService;
	private ClubService clubService;
	
	/** c. */
	@Autowired
	public HomePageService(
			PersonService personService,
			ClubService clubService
			) {
		this.personService = personService;
		this.clubService = clubService;
	}
	
	/** m. */
	public void createPersons() {
	
		for (int i=1; i<=44; i++) {
			Person person = new Person();
			/* main info */
			person.setNameFirst("Firstname00"+i);
			person.setNameLast("Lastname00"+i);
			person.setNameNick(person.getNameFirst()+" "+person.getNameLast());
			/* player parameters */
			Random random = new Random();
			person.setGoalkeeping(random.nextInt(998)+1);
			person.setShooting(random.nextInt(998)+1);
			/* save to db */
			personService.save(person);
		}
		
	}
	
	public void createClubs() {

		Club club001 = new Club();
		club001.setName("Clubname001");
		clubService.save(club001);
		
		Club club002 = new Club();
		club002.setName("Clubname002");
		clubService.save(club002);
		
		Club club003 = new Club();
		club003.setName("Clubname003");
		clubService.save(club003);
		
		Club club004 = new Club();
		club004.setName("Clubname004");
		clubService.save(club004);
		
	}
	
	public void addPersonsToClub() {
		List<Club> clubs = clubService.loadAll();
		
		int j = 1;
		for (Club club : clubs) {
			for (int i = 1; i<=11; i++) {
				Person person = personService.loadById(Long.valueOf(j));
				person.setClub(club);
				personService.save(person);
				j++;
			}
		}
		
	}
	
}