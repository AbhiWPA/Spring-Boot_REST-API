package lk.epic.assignmentone.repo;

import lk.epic.assignmentone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<User,String> {

    User findUserByEmailAndPassword(String email, String password);

}
