package lk.epic.assignmentone.controller;

import io.swagger.annotations.Api;
import lk.epic.assignmentone.dto.LoginDTO;
import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.LoginService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin
@Api(value = "LogInController", tags = "Login Controller API")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<ResponseUtil> getUserByEmailAndPswd(@Valid @RequestBody LoginDTO dto){
        ResponseUtil login = loginService.getUserById(dto);

        if (login.getCode().equals("00")) {
            return ResponseEntity.status(HttpStatus.OK).body(login);
        }else if (login.getCode().equals("02")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(login);
        }else if (login.getCode().equals("03")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(login);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(login);
        }
    }
}
