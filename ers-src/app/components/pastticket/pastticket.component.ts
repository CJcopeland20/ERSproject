import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { TicketBean } from 'src/app/class/ticket-bean';


@Component({
  selector: 'app-pastticket',
  templateUrl: './pastticket.component.html',
  styleUrls: ['./pastticket.component.css']
})
export class PastticketComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  id = this.splitCache[0];
  role_id = this.splitCache[4];

  createResponse: Subscription;
  lastStatus = 200;

  ticketArray = new Array <TicketBean>();

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.ticket();
  }

    ticket():void{
    this.httpClient.get('http://localhost:8080/ERS/past', {
      observe: 'response'
    }).pipe(map(response => response.body as Array <TicketBean>))
    .subscribe(response => {
      response.forEach(element => {
        this.ticketArray.push(element);
      });
      }, err => {   
        
      });
  }
}




