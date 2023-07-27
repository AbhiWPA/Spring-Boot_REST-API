package lk.epic.assignmentone.service;

import lk.epic.assignmentone.dto.MovieDTO;
import lk.epic.assignmentone.util.ResponseUtil;

import java.util.ArrayList;

public interface MovieService {

    public ResponseUtil addMovie(MovieDTO dto);

    public ResponseUtil deleteMovie(String imdb);

    public ResponseUtil updateMovie(MovieDTO dto);

    public ArrayList<MovieDTO> getAllMovies();

    public MovieDTO searchMovieByName(String title);

}
