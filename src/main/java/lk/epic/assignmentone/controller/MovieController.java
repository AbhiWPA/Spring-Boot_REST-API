package lk.epic.assignmentone.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lk.epic.assignmentone.config.JwtAuthenticationFilter;
import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.dto.UserDTO;
import lk.epic.assignmentone.service.MovieService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin
@Validated
@Api(value = "MoviesController", tags = "Movies Controller API")
public class MovieController {

    @Autowired
    private MovieService service;


    @GetMapping("/getAll")
    @ApiOperation(value = "Get All movies", notes = "Get All movies from the system.")
    @ApiResponse(code = 200, message = "Success", response = ResponseUtil.class)
    public ArrayList<MovieDTO> getAllMovies(){
        return service.getAllMovies();
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add a new Movie", notes = "Add a new movie to the system.")
    @ApiResponse(code = 200, message = "Success", response = ResponseUtil.class)
    public ResponseUtil saveMovie(@RequestBody MovieDTO dto){
        //System.out.println(dto);
        return service.addMovie(dto);

    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Update movie details", notes = "Update nivie details from the system.")
    @ApiResponse(code = 200, message = "Success", response = ResponseUtil.class)
    public ResponseUtil updateMovie( @RequestBody MovieDTO dto){
        return service.updateMovie(dto);
    }

    @DeleteMapping("/delete/{imdb}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Delete a movie", notes = "Delete a movie from the system.")
    @ApiResponse(code = 200, message = "Success", response = ResponseUtil.class)
    public ResponseUtil deleteMovie(@PathVariable
                                        @NotBlank(message = "IMDB shouldn't be blank or null")
                                        @NotEmpty(message = "IMDB shouldn't be empty")
                                        @Pattern(regexp = "^(tt)[0-9]{7}$", message = "IMDB must start at 'T' ") String imdb){
        return service.deleteMovie(imdb);
    }

    @GetMapping("/getById/{imdb}")
    @ApiOperation(value = "Get a movie by ID", notes = "Get a movie from the system.")
    @ApiResponse(code = 200, message = "Success", response = ResponseUtil.class)
    public ResponseUtil getMovieById(
            @NotBlank(message = "IMDB shouldn't be blank or null")
            @NotEmpty(message = "IMDB shouldn't be empty")
            @Pattern(regexp = "^(tt)[0-9]{7}$", message = "IMDB must start with 'tt' followed by 7 digits. ex:- tt0371746, tt0253645")
            @PathVariable String imdb){

        return service.searchMovieById(imdb);
    }

}
