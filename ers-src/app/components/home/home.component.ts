import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
 
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  userId = this.splitCache[0];
  role_id = this.splitCache[4];

  constructor() { }

  ngOnInit() {
  }

  managerValid(): boolean {
    return this.role_id === '2';
 }
 
  clearStorage() {
  sessionStorage.removeItem('cache');
}

}
