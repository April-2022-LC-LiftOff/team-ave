import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewModule1RoutingModule } from './new-module1-routing.module';
import { Newmodule1Component } from './newmodule1.component';
import { ProfileModule } from '../profile/profile.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';



@NgModule({
  declarations: [
    Newmodule1Component
  ],
  imports: [
    CommonModule,
    NewModule1RoutingModule,
    ProfileModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatDividerModule,
    MatIconModule,
    
    
  ]
})
export class NewModule1Module { }
