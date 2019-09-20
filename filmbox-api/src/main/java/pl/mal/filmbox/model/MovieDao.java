package pl.mal.filmbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "movie")
@Data
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
public class MovieDao implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private LocalDate worldReleaseDate;
    private LocalDate polishReleaseDate;
}
