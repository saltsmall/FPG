package pl.krzysztofskul.club;

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
	}
	/** m. CRUD read */
	/** m. CRUD update */
	/** m. CRUD delete */
	
}