package pl.mal.filmbox.facade;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pl.mal.filmbox.generated.model.FilmDto;
import pl.mal.filmbox.model.FilmDao;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
class FilmConverter {

    FilmDto filmDaoToFilmDto(FilmDao filmDao) {
        FilmDto filmDto = new FilmDto();
        BeanUtils.copyProperties(filmDao, filmDto);
        return filmDto;
    }

    List<FilmDto> filmDaoListToFilmDtoList(List<FilmDao> filmDaoList) {
        return filmDaoList.stream()
                .filter(Objects::nonNull)
                .map(this::filmDaoToFilmDto)
                .collect(Collectors.toList());
    }
}
