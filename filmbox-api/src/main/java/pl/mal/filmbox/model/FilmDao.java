package pl.mal.filmbox.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "film")
@Data
@Table(name = "films")
public class FilmDao implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
