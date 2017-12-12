package benjamin.todolistback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import benjamin.todolistback.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
	public List<Note> findByDone(boolean done);
}
