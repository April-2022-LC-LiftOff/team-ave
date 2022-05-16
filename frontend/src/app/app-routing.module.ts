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
import { TrackerComponent } from './tracker/tracker.component';
import { CrisisComponent } from './crisis/crisis.component';

import { BoardUserComponent } from './board-user/board-user.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent},
  { path: 'profile', component: ProfileComponent },
  { path: 'about', component: AboutComponent},
  { path: 'friends', component: FriendsComponent},
  { path: 'tracker', component: TrackerComponent},
  { path: 'occurrence', component: OccurrenceComponent},
  { path: 'occurrence/log', component: OccurrenceLogComponent},
  { path: 'user', component: BoardUserComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'crisis', component: CrisisComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
