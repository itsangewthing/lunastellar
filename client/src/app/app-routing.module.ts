import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home.component';
import { ReadingComponent } from './components/reading.component';
import { ReadingThreeComponent } from './components/reading-three.component';
import { SearchResultComponent } from './components/search-result.component';
import { SavedReadingsComponent } from './components/saved-readings.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'daily', component: ReadingComponent },
  { path: 'ppf', component: ReadingThreeComponent },
  { path: 'search', component: SearchResultComponent },
  { path: 'saved', component: SavedReadingsComponent },
  { path: '**', redirectTo: 'landing', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
