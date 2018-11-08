package guru.springframework.repositories;

import guru.springframework.domain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Integer> {
}
