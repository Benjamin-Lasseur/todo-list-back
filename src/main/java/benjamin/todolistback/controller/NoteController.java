package benjamin.todolistback.controller;

import java.util.List;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import benjamin.todolistback.entity.Note;
import benjamin.todolistback.service.NoteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notes")
public class NoteController {

	@Autowired
	private NoteService noteService;

	@GetMapping
	public List<Note> listerNotes() {
		return this.noteService.listerNotesNonDone();
	}

	@PostMapping
	public Note enregistrerNote(@RequestBody Note note) {
		try {
			return this.noteService.save(note);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
