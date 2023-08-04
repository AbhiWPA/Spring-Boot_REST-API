package lk.epic.assignmentone.service.impl;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.entity.Role;
import lk.epic.assignmentone.entity.User;
import lk.epic.assignmentone.repo.SignUpRepo;
import lk.epic.assignmentone.service.SignUpService;
import lk.epic.assignmentone.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@RequiredArgsConstructor
public class SignUpServiceIMPL implements SignUpService {

    @Autowired
    private SignUpRepo signUpRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseUtil saveUser(UserDTO dto) {

        var user = User.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.valueOf(String.valueOf(dto.getRole())))
                .build();

        if (signUpRepo.existsById(dto.getEmail())){
            return new ResponseUtil("04","user allready exists",user);
        }else {
//            new User().getAuthorities();
            signUpRepo.save(user);
            return new ResponseUtil("00","Success",user);
        }

    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        return null;
    }
}
