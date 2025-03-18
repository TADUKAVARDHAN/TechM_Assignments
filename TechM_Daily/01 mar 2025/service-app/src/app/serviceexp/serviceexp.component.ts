import { Component, OnInit } from '@angular/core';
import { Student } from './serviceexp.service';
@Component({
  selector: 'app-serviceexp',
  templateUrl: './serviceexp.component.html',
  styleUrls: ['./serviceexp.component.css']
})
export class ServiceexpComponent implements OnInit {
  public model:any={};
  public source:Array<any>;
  constructor(private s:Student) { 
    this.source=this.s.returnStdData();
  }
  ngOnInit(): void {
  }
  public submit(): void{
    if(this.validate()){
      this.s.addStdData(this.model);
      this.reset();
    }
  }
  public reset():void{
    this.model={};
  }
  public validate(): boolean{
    let status: boolean = true;
      if (typeof (this.model.name) === "undefined") {
          alert('Name is Blank');
          status = false;
          return status;
      }
       else if (typeof (this.model.age) === "undefined") {
          alert('Age is Blank');
          status = false;
          return status;
      }
     else if (typeof (this.model.city) === "undefined") {
          alert('City is Blank');
          status = false;
          return status;
      }
      else if (typeof (this.model.dob) === "undefined") {
          alert('dob is Blank');
          status = false;
          return status;
      }
      return status;
  }
}
