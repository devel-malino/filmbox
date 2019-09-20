import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  constructor(
    private snackBar: MatSnackBar
  ) {}
  info(message) {
    this.snackBar.open(message, 'x', {
      duration: 10000,
      panelClass: 'infoSnack',
      verticalPosition: 'top',
      horizontalPosition: 'center'
    });
  }
  error(message) {
    this.snackBar.open(message, 'x', {
      duration: 7000,
      panelClass: 'errorSnack',
      verticalPosition: 'top',
      horizontalPosition: 'center'
    });
  }

}
