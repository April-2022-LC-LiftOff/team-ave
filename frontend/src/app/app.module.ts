import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { MatSelectModule} from '@angular/material/select';
import { MatChipsModule } from '@angular/material/chips';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatIconModule} from '@angular/material/icon';
import {ReactiveFormsModule} from '@angular/forms';

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
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { UserSurveyComponent } from './user-survey/user-survey.component';

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
    HeaderComponent,
    FooterComponent,
    UserSurveyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatSelectModule,
    MatChipsModule,
    MatAutocompleteModule,
    MatIconModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
