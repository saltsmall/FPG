package pl.krzysztofskul.game;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GameService {
	
	/** p. */
	private GameRepository gameRepository;
	
	/** c. */
	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	/** m. */
	
	/** m. CRUD create */
	public void save(Game game) {
		gameRepository.save(game);
	}
	/** m. CRUD read */
	public List<Game> loadAll() {
		return gameRepository.findAll();
	}
	
	/** m. CRUD update */
	/** m. CRUD delete */
	
}