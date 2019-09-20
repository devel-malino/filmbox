package pl.mal.filmbox.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mal.filmbox.model.MovieDao;
import pl.mal.filmbox.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<MovieDao> findAll() {
        return movieRepository.findAll().stream()
                .sorted((o1, o2) -> Math.toIntExact(o1.getId() - o2.getId())).collect(Collectors.toList());
    }

    @Override
    public List<MovieDao> findAllByNameContaining(String text) {
        List<MovieDao> allByNameContaining = movieRepository.findAllByNameContaining(text);
        if (allByNameContaining == null || allByNameContaining.isEmpty()) {
            throw new NotFoundException("Nie znaleziono filmu.");
        }
        return allByNameContaining;
    }

    @Override
    public MovieDao findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Nie znalesiono filmu o id: " + id + " numeru filmu."));
    }

    @Override
    public MovieDao save(MovieDao movieDao) {
        return movieRepository.save(movieDao);
    }
}
