package benjamin.todolistback.service;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import benjamin.todolistback.entity.Note;
import benjamin.todolistback.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public List<Note> listerNotesNonDone() {
		return this.noteRepository.findByDone(false);
	}

	public Note save(Note note) throws ValidationException {
		note.setDateDebut(LocalDate.now());
		if (note.getDateFin().isBefore(LocalDate.now())) {
			throw new ValidationException("La date de fin ne peut pas être avant aujourd'hui");
		}
		if (note.isDone()) {
			throw new ValidationException("La note ne peut pas être 'done' à l'initialisation");
		}
		if (note.getTitle().trim().equals("")) {
			throw new ValidationException("Le titre de la note ne peut pas être vide");
		}
		return this.noteRepository.save(note);
	}

	public void noteDone(Note note) {
		note.setDone(true);
		this.noteRepository.save(note);
	}
}
