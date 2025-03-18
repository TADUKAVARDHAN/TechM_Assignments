import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ServiceexpComponent } from './serviceexp/serviceexp.component';
import { Student } from './serviceexp/serviceexp.service';

@NgModule({
  declarations: [
    AppComponent,
    ServiceexpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [Student],
  bootstrap: [AppComponent]
})
export class AppModule { }
