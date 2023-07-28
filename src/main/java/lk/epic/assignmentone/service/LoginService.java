package lk.epic.assignmentone.service;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.util.ResponseUtil;

public interface LoginService {

    public ResponseUtil getUserById(UserDTO dto);

}
