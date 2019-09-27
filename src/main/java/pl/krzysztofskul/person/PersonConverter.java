package pl.krzysztofskul.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PersonConverter implements Converter<String, Person> {

    @Autowired
    private PersonService personService;
    
//    @Override
    public Person convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return personService.loadById(id);
    }

}
