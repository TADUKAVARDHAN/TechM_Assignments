import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { BMICalculatorPipe } from './BMI-Calculator.pipe';

@NgModule({
    declarations: [
        AppComponent,
        BMICalculatorPipe
    ],
    imports: [
        BrowserModule,
        FormsModule
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
