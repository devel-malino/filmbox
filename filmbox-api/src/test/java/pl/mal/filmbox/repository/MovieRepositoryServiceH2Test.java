package pl.mal.filmbox.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mal.filmbox.model.MovieDao;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryServiceH2Test {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testRepo() {

        movieRepository.save(new MovieDao(null, "dziala", "Bardzo dobry film", LocalDate.now(), LocalDate.ofYearDay(2019, 32)));

        List<MovieDao> movieDaoList = movieRepository.findAllByNameContaining("d");

        assertTrue(true);
    }

}
