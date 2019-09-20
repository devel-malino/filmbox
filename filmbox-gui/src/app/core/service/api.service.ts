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
    return this.http.get<G>(this.fullUrl(url));
  }
  post<G>(object?: any, url?: string) {
    return this.http.post<G>(this.fullUrl(url), object);
  }
  update<G>(object: any, url?: string) {
    return this.http.put<G>(this.fullUrl(url), object);
  }
  fullUrl(url?: string): string {
    let base = this.baseUrl;
    if (url) {
      base += '/' + url;
    }
    return base;
  }
}
