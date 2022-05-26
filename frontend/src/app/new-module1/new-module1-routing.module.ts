import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Newmodule1Component } from './newmodule1.component';

const routes: Routes = [
  {
    path: '',
    component:Newmodule1Component
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewModule1RoutingModule { }
