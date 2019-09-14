package pl.krzysztofskul.club;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClubService {
	
	/** p. */
	private ClubRepository clubRepository;
	
	/** c. */
	@Autowired
	public ClubService(ClubRepository clubRepository) {
		this.clubRepository = clubRepository;
	}
	
	/** m. */
	
	/** m. CRUD create */
	public void save(Club club) {
		clubRepository.save(club);
	}
	/** m. CRUD read */
	public List<Club> loadAll() {
		return clubRepository.findAll();
	}
	
	public Club loadById(Long id) {
		return clubRepository.findById(id).get();
	}
	
	public Club loadByIdWithPersons(Long id) {
		Club club = clubRepository.findById(id).get();
		Hibernate.initialize(club.getPersons());
		return club;
	}
	
	/** m. CRUD update */
	/** m. CRUD delete */
	
}