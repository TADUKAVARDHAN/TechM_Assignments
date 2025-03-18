import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-eventbind',
  templateUrl: './eventbind.component.html',
  styleUrls: ['./eventbind.component.css']
})
export class EventbindComponent implements OnInit {

  constructor() { }
  public showAlert(): void {
    console.log("Heyy!!...You Clicked the Button");
    alert("File Download Completed");
  }
  ngOnInit(): void {
  }

}
