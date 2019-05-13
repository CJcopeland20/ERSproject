import { Component, OnInit } from '@angular/core';
import { AddService } from 'src/app/services/add.service';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addticket',
  templateUrl: './addticket.component.html',
  styleUrls: ['./addticket.component.css']
})
export class AddticketComponent implements OnInit {
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  id = this.splitCache[0];
  role_id = this.splitCache[4];

  date = '';
  type = 1;
  description = '';
  cost = 0;
  addResponse: Subscription;
  lastStatus = 200;

  constructor(private addService: AddService, private router: Router) { }

  ngOnInit() {
    this.addResponse = this.addService.$addStatus.subscribe(status => {
      // do something with the status here
      if (status === 200) {
        this.router.navigateByUrl('home');
      } else {
        // set status to lastStatus to display appropriate error message
        this.lastStatus = status;
      }
    });
  }


  ngOnDestroy() {
    if (this.addResponse) {
      this.addResponse.unsubscribe();
    }
  }

  formValidation(): boolean {
    return this.cost > 0 && this.date.length > 0 && this.type > 0
    && this.description.length > 0;
  }

  submit() {
    console.log('submitted');
    this.addService.add(this.date, this.id ,this.type, this.description, this.cost);
    this.router.navigateByUrl('home');
  }


}
