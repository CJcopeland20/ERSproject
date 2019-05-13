import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AddticketComponent } from './components/addticket/addticket.component';
import { PastticketComponent } from './components/pastticket/pastticket.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginService } from './services/login.service';
import { AddService } from './services/add.service';
import { UpdateticketComponent } from './components/updateticket/updateticket.component';
import { TicketService } from './services/ticket.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AddticketComponent,
    PastticketComponent,
    UpdateticketComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginService, AddService, TicketService],
  bootstrap: [AppComponent]
})
export class AppModule { }
