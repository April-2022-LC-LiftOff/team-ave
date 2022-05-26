import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { BreakpointObserver } from '@angular/cdk/layout'
import { NavigationEnd, Router } from '@angular/router';
import {delay , filter} from 'rxjs/operators';


// @UntilDestroy()
@Component({
  selector: 'app-newmodule1',
  templateUrl: './newmodule1.component.html',
  styleUrls: ['./newmodule1.component.css']
})
export class Newmodule1Component implements OnInit {
  @ViewChild(MatSidenav)
  sidenav!:MatSidenav;

  constructor(private observer: BreakpointObserver) { }

  ngAfterViewInit(){
    this.observer
    .observe(['(max-width: 800px)'])
    // .pipe(delay(1), untilDestroyed(this))
    .subscribe((res)=>{

      if(res.matches){
        this.sidenav.mode = 'over';
        this.sidenav.close();
      } else {
        this.sidenav.mode = 'side';
        this.sidenav.open();
      }
    });

    // this.router.events
    // .pipe(
    //   untilDestroyed(this),
    //   filter((e) => e instanceof NavigationEnd)
    // )
    // .subscribe(() => {
    //   if(this.sidenav.mode==='over'){
    //     this.sidenav.close();
    //   }
    // })
  }

  ngOnInit(): void {
  }

}


// import { Component, ViewChild } from '@angular/core';
// import { BreakpointObserver } from '@angular/cdk/layout';
// import { MatSidenav } from '@angular/material/sidenav';
// import { delay, filter } from 'rxjs/operators';
// import { NavigationEnd, Router } from '@angular/router';



// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: ['./app.component.scss'],
// })
// export class AppComponent {
//   @ViewChild(MatSidenav)
//   sidenav!: MatSidenav;

//   constructor(private observer: BreakpointObserver, ) {}

//   ngAfterViewInit() {
//     this.observer
//       .observe(['(max-width: 800px)'])
      
//       .subscribe((res) => {
//         if (res.matches) {
//           this.sidenav.mode = 'over';
//           this.sidenav.close();
//         } else {
//           this.sidenav.mode = 'side';
//           this.sidenav.open();
//         }
//       });
//   }
// }

