import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-strint',
  templateUrl: './strint.component.html',
  styleUrls: ['./strint.component.css']
})
export class StrintComponent implements OnInit {

  constructor() { }
  strname = 'Data Binding using String interpolation';
  num1 = 0;
  num2 = 0;
  //method
  addTwoNumbers() : number {
    return this.num1 + this.num2;
  }
  ngOnInit(): void {
  }

}
