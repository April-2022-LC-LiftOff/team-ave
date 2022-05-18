import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { FriendsComponent } from './friends/friends.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OccurrenceComponent } from './occurrence/occurrence.component';
import { RegistrationComponent } from './registration/registration.component';
import { UserSurveyComponent } from './user-survey/user-survey.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'about', component: AboutComponent},
  {path: 'friends', component: FriendsComponent},
  {path: 'occurrence', component: OccurrenceComponent},
  {path: 'survey', component: UserSurveyComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
