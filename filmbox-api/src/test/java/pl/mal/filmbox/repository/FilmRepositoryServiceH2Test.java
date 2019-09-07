package pl.mal.filmbox.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mal.filmbox.model.FilmDao;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FilmRepositoryServiceH2Test {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void testRepo() {

        filmRepository.save(FilmDao.builder().name("dziala").build());

        List<FilmDao> filmDaoList = filmRepository.findAllByNameContaining("d");

        assertTrue(true);
    }

}
