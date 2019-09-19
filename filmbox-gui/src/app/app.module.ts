import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatNativeDateModule} from '@angular/material';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModuleImporter} from './material-module-importer';
import { FilmboxComponent } from './filmbox/filmbox.component';
import {AppRoutingModule} from './app-routing.module';
import {RouterModule} from '@angular/router';
import { MainToolbarComponent } from './main-toolbar/main-toolbar.component';
import { MainContainerComponent } from './main-container/main-container.component';
import { MainFooterComponent } from './main-footer/main-footer.component';
import { MoviesComponent } from './filmbox/movies/movies.component';
import { SerialsComponent } from './filmbox/serials/serials.component';
import { GamesComponent } from './filmbox/games/games.component';
import { RankingsComponent } from './filmbox/rankings/rankings.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmboxComponent,
    MainToolbarComponent,
    MainContainerComponent,
    MainFooterComponent,
    MoviesComponent,
    SerialsComponent,
    GamesComponent,
    RankingsComponent
  ],
  imports: [
    RouterModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    MaterialModuleImporter,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

platformBrowserDynamic().bootstrapModule(AppModule);
