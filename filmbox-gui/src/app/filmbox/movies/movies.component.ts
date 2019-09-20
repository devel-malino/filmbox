import { Component, OnInit } from '@angular/core';
import {Movie} from '../../core/model/movie';
import {MovieService} from '../../core/service/movie.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  data: Movie[] = [];
  displayedColumns = ['id', 'name', 'worldReleaseDate'];
  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.movieService.findAll().subscribe(value => {
      this.data = value;
    });
  }
}
