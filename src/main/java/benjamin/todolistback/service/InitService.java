package benjamin.todolistback.service;

import java.time.LocalDate;
import java.util.stream.Stream;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import benjamin.todolistback.entity.Categorie;
import benjamin.todolistback.entity.Note;
import benjamin.todolistback.repository.CategorieRepository;

@Service
public class InitService {

	@Autowired
	private NoteService noteService;

	@Autowired
	private CategorieRepository categorieRepository;

	public void init() {
		Stream.of(new Categorie("Truc cool"), new Categorie("Truc chiant")).forEach(cat -> {
			this.categorieRepository.save(cat);
		});
		Stream.of(new Note("Note 1", "Chose à faire", LocalDate.of(2017, 12, 25), this.categorieRepository.findOne(1)),
				new Note("Note 1", "Chose à faire", LocalDate.of(2017, 12, 25), this.categorieRepository.findOne(2)))
				.forEach(note -> {
					try {
						this.noteService.save(note);
					} catch (ValidationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
		;

	}

}
