package pl.krzysztofskul.club;

import java.util.List;

import javax.transaction.Transactional;

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
		System.out.println("club saved"+club.getName());
	}
	/** m. CRUD read */
	public List<Club> loadAll() {
		return clubRepository.findAll();
	}
	
	/** m. CRUD update */
	/** m. CRUD delete */
	
}