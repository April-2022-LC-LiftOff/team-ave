import { OccurrenceListComponent } from './occurrence/occurrence-list/occurrence-list.component';
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
import { OccurrenceComponent } from './occurrence/occurrence.component';

import { OccurrenceLogComponent } from './occurrence/occurrence-log/occurrence-log.component';
import { ProfileComponent } from './profile/profile.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CrisisComponent } from './crisis/crisis.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { SurveyComponent } from './registration/survey/survey.component';

import { MatSelectModule} from '@angular/material/select';
import { MatChipsModule } from '@angular/material/chips';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { OccurrenceCardComponent } from './occurrence/occurrence-card/occurrence-card.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    FriendsComponent,
    AboutComponent,
    OccurrenceComponent,
    OccurrenceLogComponent,
    OccurrenceListComponent,
    ProfileComponent,
    HeaderComponent,
    FooterComponent,
    CrisisComponent,
    SurveyComponent,
    OccurrenceCardComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    MatSelectModule,
    MatChipsModule,
    MatAutocompleteModule,
    ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
