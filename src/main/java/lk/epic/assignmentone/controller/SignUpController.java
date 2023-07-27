package lk.epic.assignmentone.controller;

import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.SignUpService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/signUp")
@CrossOrigin
public class SignUpController {

    @Autowired
    private SignUpService service;


    @PostMapping
    public ResponseUtil userRegistration(@RequestBody UserDTO dto){
        System.out.println(dto);
        return service.saveUser(dto);

    }
}
