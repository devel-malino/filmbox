package pl.mal.filmbox.service;

import pl.mal.filmbox.model.MovieDao;

import java.util.List;

public interface MovieService {

    List<MovieDao> findAll();
    List<MovieDao> findAllByNameContaining(String text);
    MovieDao findById(Long id);
}
