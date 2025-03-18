import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root' // This ensures the service is available globally
})
export class DataService {
  private student: any = {};
  private marks: number[] = [];
  private courses: string[] = [];

  // Student Data Methods
  setStudentData(studentData: any) {
    this.student = studentData;
  }
  getStudentData() {
    return this.student;
  }

  // Marks Data Methods
  setMarksData(marksData: number[]) {
    this.marks = marksData;
  }
  getMarksData() {
    return this.marks;
  }

  // Courses Data Methods
  setCoursesData(coursesData: string[]) {
    this.courses = coursesData;
  }
  getCoursesData() {
    return this.courses;
  }
}
