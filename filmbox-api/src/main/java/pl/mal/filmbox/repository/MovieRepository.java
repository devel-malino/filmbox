package pl.mal.filmbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mal.filmbox.model.MovieDao;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieDao, Long> {

    List<MovieDao> findAllByNameContaining(@Param("name") String text);
}
