import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { FriendsComponent } from './friends/friends.component';
import { AboutComponent } from './about/about.component';
import { TrackerComponent } from './tracker/tracker.component';
import { OccurrenceComponent } from './occurrence/occurrence.component';
import { ReviewOccurrenceComponent } from './review-occurrence/review-occurrence.component';

import { OccurrenceLogComponent } from './occurrence/occurrence-log/occurrence-log.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CrisisComponent } from './crisis/crisis.component';
import { PostRegistrationComponent } from './registration/post-registration/post-registration.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    FriendsComponent,
    AboutComponent,
    TrackerComponent,
    OccurrenceComponent,
    ReviewOccurrenceComponent,
    OccurrenceLogComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardUserComponent,
    HeaderComponent,
    FooterComponent,
    CrisisComponent,
    PostRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
