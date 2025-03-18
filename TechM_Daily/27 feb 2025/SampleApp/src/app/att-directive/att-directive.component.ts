import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-att-directive',
  templateUrl: './att-directive.component.html',
  styleUrls: ['./att-directive.component.css']
})
export class AttDirectiveComponent implements OnInit {
  showColor = false;

  constructor() { }

  //a public method
  public changeColor(): void {
    this.showColor = !this.showColor;

  ngOnInit(): void {

  }

}
