import {ApiService} from './api.service';
import {Observable} from 'rxjs';
import {Movie} from '../model/movie';
import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

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
}
