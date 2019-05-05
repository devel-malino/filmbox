package pl.mal.filmbox.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import pl.mal.filmbox.model.FilmDao;

import java.util.List;

public interface FilmRepository extends JpaRepository<FilmDao, Long> {

    List<FilmDao> findAllByNameContaining(@Param("name") String text);
}
