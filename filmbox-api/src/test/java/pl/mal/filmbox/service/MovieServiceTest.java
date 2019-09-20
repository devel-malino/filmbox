package pl.mal.filmbox.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.mal.filmbox.repository.MovieRepository;

import java.util.Collections;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieServiceImpl filmService;

    @Mock
    private MovieRepository movieRepository;

    @Test(expected = NotFoundException.class)
    public void findAllByNameContainingTest() {
        //given
        String SEARCHED_PHRASE = "r W";

        //when
        when(movieRepository.findAllByNameContaining(SEARCHED_PHRASE)).thenReturn(Collections.emptyList());

        //then
        assertNotNull(filmService.findAllByNameContaining(SEARCHED_PHRASE));
    }

}
