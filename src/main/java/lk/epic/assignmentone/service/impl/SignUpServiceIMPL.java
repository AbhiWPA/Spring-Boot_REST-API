package lk.epic.assignmentone.service.impl;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.entity.User;
import lk.epic.assignmentone.repo.SignUpRepo;
import lk.epic.assignmentone.service.SignUpService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class SignUpServiceIMPL implements SignUpService {

    @Autowired
    private SignUpRepo signUpRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ResponseUtil saveUser(UserDTO dto) {
        if (signUpRepo.existsById(dto.getEmail())){
            return new ResponseUtil("04","user allready exists",dto);
        }else {
            signUpRepo.save(mapper.map(dto, User.class));
            return new ResponseUtil("00","Success",dto);
        }

    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        return null;
    }
}
