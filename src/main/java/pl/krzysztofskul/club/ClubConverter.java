package pl.krzysztofskul.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ClubConverter implements Converter<String, Club> {

    @Autowired
    private ClubService clubService;
    
//    @Override
    public Club convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return clubService.loadById(id);
    }

}
