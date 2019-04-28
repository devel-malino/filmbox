package pl.mal.filmbox.reposiotry;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mal.filmbox.model.FilmDao;

public interface FilmRepository extends JpaRepository<FilmDao, Long> {
}
