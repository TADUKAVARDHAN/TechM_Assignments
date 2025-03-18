import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-propbind',
  templateUrl: './propbind.component.html',
  styleUrls: ['./propbind.component.css']
})
export class PropbindComponent implements OnInit {

  constructor() { }
  str1 = "Rendering images using Property binding";
  imgUrl = 'assets/imgs/Anurag.png';
  ngOnInit(): void {
  }

}
