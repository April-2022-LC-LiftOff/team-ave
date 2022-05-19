import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  navItem=[
  {
  path:'/',
  name:'Home'
  },
  {
    path:'/login',
    name:'Login'
    },
    {
        path:'/registration',
        name:'Registration'
        },
        {
            path:'/home',
            name:'Something Else'
            }

  ]
  constructor() { }

  ngOnInit(): void {
  }

}
