package pl.mal.filmbox.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mal.filmbox.model.FilmDao;
import pl.mal.filmbox.reposiotry.FilmRepository;

import java.util.List;

@Service
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public List<FilmDao> findAll() {
        return filmRepository.findAll();
    }
}
