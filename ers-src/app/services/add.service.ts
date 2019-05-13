import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddService {
  private addStatusSubject = new Subject<number>();
  public  $addStatus = this.addStatusSubject.asObservable();

  constructor(private httpClient: HttpClient) { }

  add(date: string, id: string, type: number, description: string, cost: number): void {
    const payload = {
      date: date,
      id: id,
      type: type,
      description: description,
      cost: cost
    };

    console.log(payload);

    this.httpClient.post('http://localhost:8080/ERS/add', payload, {
        observe: 'response'
      }).subscribe(response => {
        console.log('request sent');
        this.addStatusSubject.next(200);
      }, err => {
        this.addStatusSubject.next(err.status);
      });
  }
}
