import { Component } from '@angular/core';
import { DataService } from '../../data.service'; // Import DataService

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  student = { name: '', age: null, grade: '', email: '' };
  submitted = false;

  constructor(private dataService: DataService) {} // Inject DataService

  submitForm() {
    this.submitted = true;
    this.dataService.setStudentData(this.student); // Store in service
  }
}
