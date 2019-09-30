package pl.krzysztofskul.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person, Long> {

//	@Query(value = "SELECT * FROM Persons", 
//			nativeQuery = true)
//	List<Person> findAllForHire();
	
	List<Person> findByIsHired(boolean isHired);
	
}