import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service'; // Import DataService

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  student: any = {};
  marks: number[] = [];
  courses: string[] = [];

  constructor(private dataService: DataService) {} // Inject DataService

  ngOnInit() {
    this.student = this.dataService.getStudentData();
    this.marks = this.dataService.getMarksData();
    this.courses = this.dataService.getCoursesData();
  }
}
