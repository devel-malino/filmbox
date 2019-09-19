import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {FilmboxComponent} from './filmbox/filmbox.component';
import {MoviesComponent} from './filmbox/movies/movies.component';
import {SerialsComponent} from './filmbox/serials/serials.component';
import {GamesComponent} from './filmbox/games/games.component';
import {RankingsComponent} from './filmbox/rankings/rankings.component';

const appRoutes: Routes = [
  {
    path: 'movies',
    component: MoviesComponent
  },
  {
    path: 'serials',
    component: SerialsComponent
  },
  {
    path: 'games',
    component: GamesComponent
  },
  {
    path: 'rankings',
    component: RankingsComponent
  }
];
const routes: Routes = [
  {
    path: 'app',
    component: FilmboxComponent,
    children: appRoutes
  },
  {
    path: '**',
    redirectTo: 'app'
  },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
