package pl.mal.filmbox.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import pl.mal.filmbox.facade.FilmFacade;
import pl.mal.filmbox.generated.definition.FilmApi;
import pl.mal.filmbox.generated.model.FilmDto;

import java.util.List;

@RestController
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmController implements FilmApi {

    private final FilmFacade filmFacade;

    @Override
    public ResponseEntity<List<FilmDto>> findAllFilms() {
        return ResponseEntity.ok(filmFacade.findAll());
    }
}
