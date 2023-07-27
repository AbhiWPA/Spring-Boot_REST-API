package lk.epic.assignmentone.controller;

import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.MovieService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping("/add")
    public ResponseUtil saveMovie(@RequestBody MovieDTO dto){
        //System.out.println(dto);
        return service.addMovie(dto);

    }

    @PutMapping("/update")
    public ResponseUtil updateMovie(@RequestBody MovieDTO dto){
        return service.updateMovie(dto);
    }

}
