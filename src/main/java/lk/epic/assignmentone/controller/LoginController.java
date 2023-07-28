package lk.epic.assignmentone.controller;

import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.LoginService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseUtil getUserByEmailAndPswd(@RequestBody UserDTO dto){
        return loginService.getUserById(dto);
    }
}
