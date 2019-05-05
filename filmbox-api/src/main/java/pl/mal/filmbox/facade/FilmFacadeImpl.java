package pl.mal.filmbox.facade;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mal.filmbox.generated.model.FilmDto;
import pl.mal.filmbox.service.FilmService;

import java.util.List;

@Service
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmFacadeImpl implements FilmFacade {

    private final FilmService filmService;
    private final FilmConverter filmConverter;

    @Override
    public List<FilmDto> findAll() {
        return filmConverter.filmDaoListToFilmDtoList(filmService.findAll());
    }

    @Override
    public List<FilmDto> findAllByNameContaining(String text) {
        return filmConverter.filmDaoListToFilmDtoList(filmService.findAllByNameContaining(text));
    }
}
