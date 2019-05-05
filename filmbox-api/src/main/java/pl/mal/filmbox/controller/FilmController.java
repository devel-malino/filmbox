package pl.mal.filmbox.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mal.filmbox.facade.FilmFacade;
import pl.mal.filmbox.generated.definition.FilmApi;
import pl.mal.filmbox.generated.model.FilmDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmController implements FilmApi {

    private final FilmFacade filmFacade;

    @Override
    public ResponseEntity<List<FilmDto>> findAllByNameContaining(@ApiParam(value = "Searching films by text") @Valid @RequestParam(value = "text", required = false) String text) {
        return ResponseEntity.ok(filmFacade.findAllByNameContaining(text));
    }

    @Override
    public ResponseEntity<List<FilmDto>> findAll() {
        return ResponseEntity.ok(filmFacade.findAll());
    }
}
