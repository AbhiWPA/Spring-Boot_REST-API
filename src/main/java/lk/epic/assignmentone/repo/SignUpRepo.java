package lk.epic.assignmentone.repo;

import lk.epic.assignmentone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepo extends JpaRepository<User,String> {
}
