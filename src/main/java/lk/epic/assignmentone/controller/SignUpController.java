package lk.epic.assignmentone.controller;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.SignUpService;
import lk.epic.assignmentone.util.AuthenticationResponse;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/signUp")
@CrossOrigin
public class SignUpController {

    @Autowired
    private SignUpService service;


    @PostMapping("/register")
    public ResponseEntity<ResponseUtil> userRegistration(@Valid @RequestBody UserDTO dto){
        //System.out.println(dto);
        //return service.saveUser(dto);
        System.out.println("User : "+dto);
        ResponseUtil signUp = service.saveUser(dto);

        if (signUp.getCode().equals("00")) {
            return ResponseEntity.status(HttpStatus.OK).body(signUp);
        }else if (signUp.getCode().equals("04")){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(signUp);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(signUp);
        }

    }


}
