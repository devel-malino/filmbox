package pl.mal.filmbox.facade;

import pl.mal.filmbox.generated.model.FilmDto;

import java.util.List;

public interface FilmFacade {

    List<FilmDto> findAll();
}
