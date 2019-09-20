import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  serverUrl = 'http://localhost:8080/filmbox/';
  baseUrl = '';
  constructor(public http: HttpClient, private objectUrl: string) {
    this.baseUrl = this.serverUrl + objectUrl;
  }
  get<G>(url?: string) {
    let base = this.baseUrl;
    if (url) {
      base += '/' + url;
    }
    return this.http.get<G>(base);
  }
}
