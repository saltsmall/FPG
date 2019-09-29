package pl.krzysztofskul.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query(value = "SELECT * FROM Persons WHERE club_id IS NULL", 
			nativeQuery = true)
	List<Person> findAllForHire();
	
}