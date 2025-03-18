import { Component } from '@angular/core';
import { DataService } from '../../data.service'; // Import DataService

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  courses: string[] = [];
  newCourse: string = '';
  submitted = false;

  constructor(private dataService: DataService) {} // Inject DataService

  addCourse() {
    if (this.newCourse.trim() !== '') {
      this.courses.push(this.newCourse.trim());
      this.newCourse = '';
    }
  }

  submitCourses() {
    this.submitted = true;
    this.dataService.setCoursesData(this.courses); // Store in service
  }
}
