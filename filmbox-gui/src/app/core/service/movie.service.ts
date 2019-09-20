import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Movie} from '../model/movie';
import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {finalize} from 'rxjs/operators';
import {MessageService} from './message.service';

@Injectable({
  providedIn: 'root'
})
export class MovieService extends ApiService implements OnInit {
  constructor(http: HttpClient) {
    super(http, 'movie');
  }

  ngOnInit(): void {
  }
  public findAll(): Observable<Array<Movie>> {
    return this.get<Array<Movie>>();
  }
  public findById(id: number): Observable<Movie> {
    return this.get<Movie>(id.toString());
  }
  public save(movie: Movie): Observable<Movie> {
    if (movie) {
      movie = this.convertMovieDate(movie);
      if (movie.id) {
        return this.update<Movie>(movie);
      } else {
        return this.post<Movie>(movie);
      }
    }
    return Observable.create();
  }
  private convertMovieDate(movie: Movie): Movie {
    if (movie.worldReleaseDate) {
      const date = new Date(movie.worldReleaseDate);
      movie.worldReleaseDate = this.dateParse(date);
    } else {
      movie.worldReleaseDate = null;
    }
    if (movie.polishReleaseDate) {
      const date = new Date(movie.polishReleaseDate);
      movie.polishReleaseDate = this.dateParse(date);
    } else {
      movie.polishReleaseDate = null;
    }
    return movie;
  }
  private dateParse(date: Date): string {
    let day: string = date.getDate().toString();
    if (day && day.length < 2) {
      day = '0' + day;
    }
    let month: string = (date.getUTCMonth() + 1).toString();
    if (month && month.length < 2) {
      month = '0' + month;
    }
    return date.getFullYear() + '-' + month + '-' + day;
  }
}
