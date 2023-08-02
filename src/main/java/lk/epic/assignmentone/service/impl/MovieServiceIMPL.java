package lk.epic.assignmentone.service.impl;

import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.entity.Movie;
import lk.epic.assignmentone.entity.User;
import lk.epic.assignmentone.repo.MovieRepo;
import lk.epic.assignmentone.repo.SignUpRepo;
import lk.epic.assignmentone.service.MovieService;
import lk.epic.assignmentone.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class MovieServiceIMPL implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ModelMapper mapper;

    private AuthenticationManager authenticationManager;

    @Override
    public ResponseUtil addMovie(MovieDTO dto) {
        if (movieRepo.existsById(dto.getImdb())){
            return new ResponseUtil("04","Movie allready exists",dto);
        }else {
            movieRepo.save(mapper.map(dto, Movie.class));
            return new ResponseUtil("00","Success",dto);
        }
    }

    @Override
    public ResponseUtil deleteMovie(String imdb) {
        if (movieRepo.existsById(imdb)){
            movieRepo.deleteById(imdb);
            return new ResponseUtil("00", "Delete Success", imdb);
        } else {
            return new ResponseUtil("02", "No Such Movie Exists", imdb);
        }

    }

    @Override
    public ResponseUtil updateMovie(MovieDTO dto) {
        if (movieRepo.existsById(dto.getImdb())) {
           movieRepo.save(mapper.map(dto, Movie.class));
            return new ResponseUtil("00", "Update Success", dto);
        } else {
            return new ResponseUtil("02", "No Such Movie Exists", dto);
        }
    }

    @Override
    public ArrayList<MovieDTO> getAllMovies() {
        return mapper.map(movieRepo.findAll(), new TypeToken<ArrayList<MovieDTO>>() {
        }.getType());
    }

    @Override
    public MovieDTO searchMovieByName(String title) {
        return null;
    }
}
