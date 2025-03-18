import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './components/student/student.component';
import { CoursesComponent } from './components/courses/courses.component';
import { MarksComponent } from './components/marks/marks.component';

const routes: Routes = [
  { path: 'student', component: StudentComponent },
  { path: 'marks', component: MarksComponent },
  { path: 'courses', component: CoursesComponent },
  { path: '', redirectTo: '/student', pathMatch: 'full' } // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
