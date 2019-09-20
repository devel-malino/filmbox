import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MovieService} from '../../../core/service/movie.service';
import {Movie} from '../../../core/model/movie';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {finalize} from 'rxjs/operators';
import {MessageService} from '../../../core/service/message.service';

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
    private movieService: MovieService,
    private messageService: MessageService,
    private router: Router
  ) {
    this.movieId = +this.route.snapshot.paramMap.get('id');
  }

  ngOnInit() {
    this.loadingData = true;
    this.loadData();
  }
  loadData() {
    if (this.movieId !== 0 && this.movieId) {
      this.movieService.findById(this.movieId)
        .pipe(finalize(() => this.loadingData = false))
        .subscribe(value => {
        if (value) {
          this.newFilm = false;
          this.form = this.setFormValue(value);
        }
      }, error => {
        console.log(error);
      });
    } else {
      this.form = this.setFormValue();
      this.loadingData = false;
    }
  }
  setFormValue(movie?: Movie): FormGroup {
    return new FormGroup({
      id: new FormControl(movie ? movie.id : null),
      name: new FormControl(movie ? movie.name : '', Validators.required),
      description: new FormControl(movie ? movie.description : ''),
      worldReleaseDate: new FormControl(movie ? movie.worldReleaseDate : ''),
      polishReleaseDate: new FormControl(movie ? movie.polishReleaseDate : '')
    });
  }
  save() {
    if (this.form.valid) {
      const object: Movie = this.form.value;
      this.loadingData = true;
      this.movieService.save(object)
        .pipe(finalize(() => this.loadingData = false))
        .subscribe(value => {
          this.messageService.info('Dane zapisano poprawnie.');
          this.router.navigateByUrl('/app/movies/' + value.id);
        }, error => {
          console.log(error);
          this.messageService.error('Błąd zapisu danych.');
        });
    }
  }
}
