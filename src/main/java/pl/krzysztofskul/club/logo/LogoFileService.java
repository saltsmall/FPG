package pl.krzysztofskul.club.logo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import pl.krzysztofskul.club.Club;

@Service
@Transactional
public class LogoFileService {

	@Autowired
	private LogoFileRepository logoFileRepository;
	
	public LogoFile saveLogoFile (MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new RuntimeException("Invalid sequence!");
			}
			
			LogoFile logoFile = new LogoFile(fileName, file.getContentType(), file.getBytes());
			return logoFileRepository.save(logoFile);
		} catch (IOException ex) {
			throw new RuntimeException("Couldn't store the file! Try again.");
		}
	}
	
    public LogoFile getFile(Long id) throws FileNotFoundException {
        return logoFileRepository.findById(id).get();
    }
    
    public LogoFile getFileByClub(Club club) {
    	return logoFileRepository.findById(club.getLogo().getId()).get();
    }

    public List<LogoFile> findAll() {
        return logoFileRepository.findAll();
    }

    public void delete(Long id) {
    	logoFileRepository.deleteById(id);
    }

    public LogoFile findById(Long id) {
        return logoFileRepository.findById(id).get();
    }
	
	
}
