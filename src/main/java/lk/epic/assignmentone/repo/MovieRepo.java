package lk.epic.assignmentone.repo;

import lk.epic.assignmentone.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,String> {
}
