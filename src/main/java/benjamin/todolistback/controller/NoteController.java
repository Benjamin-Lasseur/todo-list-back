package benjamin.todolistback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Note> listerNotes(){
		return this.noteService.listerNotesNonDone();
	}

}
