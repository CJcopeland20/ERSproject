import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TicketBean } from 'src/app/class/ticket-bean';

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private ticketSubject = new Subject<number>();
  public $ticketStatus = this.ticketSubject.asObservable();
  ticketArray = new Array <TicketBean>();
  
  constructor(private httpClient: HttpClient) { }
   
}
