import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { TicketBean } from 'src/app/class/ticket-bean';
import { UpdateService } from 'src/app/services/update.service';

@Component({
  selector: 'app-updateticket',
  templateUrl: './updateticket.component.html',
  styleUrls: ['./updateticket.component.css']
})
export class UpdateticketComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  id = this.splitCache[0];
  role_id = this.splitCache[4];

  createResponse: Subscription;
  lastStatus = 200;
  status = 0;

  ticketArray = new Array <TicketBean>();

  constructor(private httpClient: HttpClient, private updateService: UpdateService) { }

  ngOnInit() {
    this.ticket();
  }
  ticket():void{
    this.httpClient.get('http://localhost:8080/ERS/update', {
      observe: 'response'
    }).pipe(map(response => response.body as Array <TicketBean>))
    .subscribe(response => {
      response.forEach(element => {
        this.ticketArray.push(element);
      });
      }, err => {   
        
      });
  }

  update(status: number, id: number):void{
    const payload ={
      status: status,
      id: id
    };
    this.httpClient.put('http://localhost:8080/ERS/resolve', payload, {
      observe: 'response'
    }).subscribe(response => {
      console.log('request sent');
      
    }, err => {
      
    });
  }

  pending(item): boolean{
    console.log(item);
    return item.status === 1;

  }



}