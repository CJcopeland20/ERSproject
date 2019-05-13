import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TicketBean } from 'src/app/class/ticket-bean';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {

  private ticketSubject = new Subject<number>();
  public $ticketStatus = this.ticketSubject.asObservable();
  ticketArray = new Array <TicketBean>();
  
  constructor(private httpClient: HttpClient) { }

  update(status: number): void{
    const payload = {
      status: status
    };
    
    console.log(payload);

    


  }

}
