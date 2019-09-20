import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {MovieService} from '../../../core/service/movie.service';
import {__values} from 'tslib';
import {Movie} from '../../../core/model/movie';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-movie-item',
  templateUrl: './movie-item.component.html',
  styleUrls: ['./movie-item.component.css']
})
export class MovieItemComponent implements OnInit {
  movieId: number = null;
  newFilm = true;
  loadingData = true;
  public form: FormGroup;
  constructor(
    private route: ActivatedRoute,
    private movieService: MovieService
  ) {
    this.movieId = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit() {
    this.loadingData = true;
    this.loadData();
  }
  loadData() {
    if (this.movieId !== 0 && this.movieId) {
      this.movieService.findById(this.movieId).subscribe(value => {
        if (value) {
          this.newFilm = false;
          this.form = this.setFormValue(value);
          this.loadingData = false;
        }
      }, error => {
        console.log(error);
        this.form = this.setFormValue();
        this.loadingData = false;
      });
    }
  }
  setFormValue(movie?: Movie): FormGroup {
    return new FormGroup({
      name: new FormControl(movie ? movie.name : '', Validators.required),
      description: new FormControl(movie ? movie.description : '', Validators.required),
      worldReleaseDate: new FormControl(movie ? movie.worldReleaseDate : ''),
      polishReleaseDate: new FormControl(movie ? movie.polishReleaseDate : '')
    });
  }
}
