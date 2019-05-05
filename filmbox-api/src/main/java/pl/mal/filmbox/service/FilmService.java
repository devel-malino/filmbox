package pl.mal.filmbox.service;

import pl.mal.filmbox.model.FilmDao;

import java.util.List;

public interface FilmService {

    List<FilmDao> findAll();
    List<FilmDao> findAllByNameContaining(String text);
}
