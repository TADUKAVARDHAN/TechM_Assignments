import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'bmiCalculator'
})
export class BMICalculatorPipe implements PipeTransform {
  transform(weight: number, height: number): string {
    if (weight && height && !isNaN(weight) && !isNaN(height) && height > 0) {
      const bmi = weight / ((height / 100) * (height / 100)); // Convert height from cm to meters
      return `${bmi.toFixed(2)} - ${this.getBMICategory(bmi)}`;
    }
    return 'Invalid input';
  }

  private getBMICategory(bmi: number): string {
    if (bmi < 18.5) {
      return 'Underweight';
    } else if (bmi >= 18.5 && bmi < 24.9) {
      return 'Normal Weight';
    } else if (bmi >= 25 && bmi < 29.9) {
      return 'Overweight';
    } else {
      return 'Obese';
    }
  }
}
