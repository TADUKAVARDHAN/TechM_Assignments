import { Component } from '@angular/core';
import { DataService } from '../../data.service'; // Import DataService

@Component({
  selector: 'app-marks',
  templateUrl: './marks.component.html',
  styleUrls: ['./marks.component.css']
})
export class MarksComponent {
  marks: number[] = [];
  newMark: number | null = null;
  submitted = false;

  constructor(private dataService: DataService) {} // Inject DataService

  addMark() {
    if (this.newMark !== null && this.newMark >= 0 && this.newMark <= 100) {
      this.marks.push(this.newMark);
      this.newMark = null;
    }
  }

  submitMarks() {
    this.submitted = true;
    this.dataService.setMarksData(this.marks); // Store in service
  }
}
