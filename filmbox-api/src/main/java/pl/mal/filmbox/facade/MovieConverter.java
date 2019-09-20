package pl.mal.filmbox.facade;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pl.mal.filmbox.generated.model.MovieDto;
import pl.mal.filmbox.model.MovieDao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
class MovieConverter {
    final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    MovieDto movieDaoToMovieDto(MovieDao movieDao) {
        MovieDto MovieDto = new MovieDto();
        BeanUtils.copyProperties(movieDao, MovieDto);
        if (movieDao.getWorldReleaseDate() != null) {
            MovieDto.setWorldReleaseDate(movieDao.getWorldReleaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        if (movieDao.getPolishReleaseDate() != null) {
            MovieDto.setPolishReleaseDate(movieDao.getPolishReleaseDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
        return MovieDto;
    }

    List<MovieDto> filmDaoListToMovieDtoList(List<MovieDao> movieDaoList) {
        return movieDaoList.stream()
                .filter(Objects::nonNull)
                .map(this::movieDaoToMovieDto)
                .collect(Collectors.toList());
    }

    MovieDao movieDtoToMovieDao(MovieDto movieDto) {
        MovieDao movieDao = new MovieDao();
        BeanUtils.copyProperties(movieDto, movieDao);
        if (movieDto.getWorldReleaseDate() != null) {
            movieDao.setWorldReleaseDate(LocalDate.parse(movieDto.getWorldReleaseDate(), DATE_FORMATTER));
        }
        if (movieDto.getPolishReleaseDate() != null) {
            movieDao.setPolishReleaseDate(LocalDate.parse(movieDto.getPolishReleaseDate(), DATE_FORMATTER));
        }
        return movieDao;
    }
}
