package lk.epic.assignmentone.service;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.util.ResponseUtil;

import java.util.ArrayList;

public interface SignUpService {

    public ResponseUtil saveUser(UserDTO dto);

    public ArrayList<UserDTO> getAllUsers();
}
