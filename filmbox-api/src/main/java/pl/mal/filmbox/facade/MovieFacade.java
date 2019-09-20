package pl.mal.filmbox.facade;

import pl.mal.filmbox.generated.model.MovieDto;

import java.util.List;

public interface MovieFacade {

    List<MovieDto> findAll();
    MovieDto findById(Long id);
    List<MovieDto> findAllByNameContaining(String text);
}
