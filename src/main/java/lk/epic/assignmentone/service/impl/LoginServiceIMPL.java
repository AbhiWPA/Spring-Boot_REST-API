package lk.epic.assignmentone.service.impl;

import lk.epic.assignmentone.advice.AppWideExceptionHandler;
import lk.epic.assignmentone.config.JwtService;
import lk.epic.assignmentone.dto.LoginDTO;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.entity.Role;
import lk.epic.assignmentone.entity.User;
import lk.epic.assignmentone.repo.LoginRepo;
import lk.epic.assignmentone.service.LoginService;
import lk.epic.assignmentone.util.AuthenticationResponse;
import lk.epic.assignmentone.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public ResponseUtil getUserById(LoginDTO dto) {

//        if(loginRepo.existsById(dto.getEmail())) {
//            authenticationManager = new AuthenticationManager() {
//                @Override
//                public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                    new UsernamePasswordAuthenticationToken(
//                            dto.getEmail(),
//                            dto.getPassword()
//                    )
//
//                }
//            }
//        }
//
//            var jwtToken = jwtService.generateToken(user);
//            AuthenticationResponse.builder().token(jwtToken).build();
//
//            User login = loginRepo.findUserByEmailAndPassword(dto.getEmail(), dto.getPassword());
//
//
//
//            if (login != null){
//                return new ResponseUtil("00", "login success", dto);
//            } else {
//                return new ResponseUtil("02", "no such user exists", null);
//            }
//        }
//        return new ResponseUtil("03", "Invalid Credentials", null);

        if (loginRepo.existsById(dto.getEmail())){
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.getEmail(),
                            dto.getPassword()
                    )
            );

            var user = loginRepo.findById(dto.getEmail()).get();
            var jwtToken = jwtService.generateToken(user);


            if (authentication != null){
                return new ResponseUtil("00", "login success",  AuthenticationResponse.builder().token(jwtToken).build());
            } else {
                return new ResponseUtil("02", "no such user exists", null);
            }

        }

        return new ResponseUtil("03", "Invalid Credentials", null);



    }
}
