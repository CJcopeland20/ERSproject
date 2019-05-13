import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AddticketComponent } from './components/addticket/addticket.component';
import { PastticketComponent } from './components/pastticket/pastticket.component';
import { UpdateticketComponent } from './components/updateticket/updateticket.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },{
    path: 'home',
    component: HomeComponent
  },{
    path: 'add',
    component: AddticketComponent
  },{
    path: 'past',
    component: PastticketComponent
  },{
    path: 'update',
    component: UpdateticketComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
