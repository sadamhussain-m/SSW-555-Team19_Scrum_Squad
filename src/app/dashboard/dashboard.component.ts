import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
  public totalUsers: number = 1000;
  public activeUsers: number = 750;
  public newUsersToday: number = 25;

  constructor() { }

  
}
