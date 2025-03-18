import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './components/student/student.component';
import { CoursesComponent } from './components/courses/courses.component';
import { MarksComponent } from './components/marks/marks.component';
import { FormsModule } from '@angular/forms';
import { DataService } from './data.service'; // Import DataService

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    CoursesComponent,
    MarksComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [DataService], // Ensure DataService is provided
  bootstrap: [AppComponent]
})
export class AppModule { }
