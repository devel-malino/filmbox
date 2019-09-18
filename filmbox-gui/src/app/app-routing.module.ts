import {RouterModule, Routes} from '@angular/router';
import {NgModel} from '@angular/forms';
import {NgModule} from '@angular/core';
import {FilmboxComponent} from './filmbox/filmbox.component';

const appRoutes: Routes = [];
const routes: Routes = [
  {
    path: '**',
    redirectTo: 'app'
  },
  {
    path: 'app',
    component: FilmboxComponent
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
