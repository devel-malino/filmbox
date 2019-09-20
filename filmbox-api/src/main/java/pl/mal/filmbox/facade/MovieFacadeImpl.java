package pl.mal.filmbox.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mal.filmbox.generated.model.MovieDto;
import pl.mal.filmbox.service.MovieService;

import java.util.List;

@Service
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieFacadeImpl implements MovieFacade {

    private final MovieService movieService;
    private final MovieConverter movieConverter;

    @Override
    public List<MovieDto> findAll() {
        return movieConverter.filmDaoListToMovieDtoList(movieService.findAll());
    }

    @Override
    public MovieDto findById(Long id) {
        return movieConverter.movieDaoToMovieDto(movieService.findById(id));
    }

    @Override
    public List<MovieDto> findAllByNameContaining(String text) {
        return movieConverter.filmDaoListToMovieDtoList(movieService.findAllByNameContaining(text));
    }

    @Override
    public MovieDto create(MovieDto movie) {
        return movieConverter.movieDaoToMovieDto(movieService.save(movieConverter.movieDtoToMovieDao(movie)));
    }

    @Override
    public MovieDto update(MovieDto movie) {
        return movieConverter.movieDaoToMovieDto(movieService.save(movieConverter.movieDtoToMovieDao(movie)));
    }
}
