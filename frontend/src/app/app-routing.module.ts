import { OccurrenceListComponent } from './occurrence/occurrence-list/occurrence-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { FriendsComponent } from './friends/friends.component';
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OccurrenceComponent } from './occurrence/occurrence.component';
import { OccurrenceLogComponent } from './occurrence/occurrence-log/occurrence-log.component';
import { RegistrationComponent } from './registration/registration.component';
import { CrisisComponent } from './crisis/crisis.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent},
  { path: 'profile', component: ProfileComponent },
  { path: 'about', component: AboutComponent},
  { path: 'friends', component: FriendsComponent},
  { path: 'occurrence', component: OccurrenceComponent},
  { path: 'occurrence/log', component: OccurrenceLogComponent},
  { path: 'occurrence/list/:id', component: OccurrenceListComponent},
  { path: 'crisis', component: CrisisComponent},
  {
    path:'new-module', 
    loadChildren: () => import('src/app/new-module1/new-module1.module').then((m) => m.NewModule1Module)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
