package lk.epic.assignmentone.service.impl;

import lk.epic.assignmentone.advice.AppWideExceptionHandler;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.entity.User;
import lk.epic.assignmentone.repo.LoginRepo;
import lk.epic.assignmentone.service.LoginService;
import lk.epic.assignmentone.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginServiceIMPL implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public ResponseUtil getUserById(UserDTO dto) {
        if(loginRepo.existsById(dto.getEmail())){
            User login = loginRepo.findUserByEmailAndPassword(dto.getEmail(), dto.getPassword());

            if (login != null){
                return new ResponseUtil("00", "login success", dto);
            } else {
                return new ResponseUtil("02", "no such user exists", null);
            }
        }
        return new ResponseUtil("03", "Invalid Credentials", null);
    }
}
