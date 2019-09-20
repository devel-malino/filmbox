package pl.mal.filmbox.controller;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mal.filmbox.facade.MovieFacade;
import pl.mal.filmbox.generated.definition.MovieApi;
import pl.mal.filmbox.generated.model.MovieDto;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController implements MovieApi {

    private final MovieFacade movieFacade;

    @Override
    public ResponseEntity<List<MovieDto>> findAllByNameContaining(@ApiParam(value = "Searching films by text") @Valid @RequestParam(value = "text", required = false) String text) {
        return ResponseEntity.ok(movieFacade.findAllByNameContaining(text));
    }

    @Override
    public ResponseEntity<List<MovieDto>> findAll() {
        return ResponseEntity.ok(movieFacade.findAll());
    }

    @Override
    public ResponseEntity<Object> findById(@ApiParam(value = "Searching movies by specific id",required=true) @PathVariable("id") BigDecimal id) {
        return ResponseEntity.ok(movieFacade.findById(id.longValue()));
    }
}
