import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-temperature-converter',
  templateUrl: './temperature-converter.component.html',
  styleUrls: ['./temperature-converter.component.css']
})
export class TemperatureConverterComponent implements OnInit {
  tempForm!: FormGroup;
  convertedTemp: number | null = null;
  selectedUnit: string = 'Celsius';

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.tempForm = this.fb.group({
      temperature: ['', [Validators.required, Validators.pattern('^-?[0-9]+(\\.[0-9]+)?$')]],
      unit: ['Celsius', Validators.required]
    });

    // Watch for unit changes and reset the converted temperature
    this.tempForm.get('unit')?.valueChanges.subscribe(() => {
      this.convertedTemp = null;
    });
  }

  convertTemperature() {
    if (this.tempForm.invalid) return;

    const tempValue = parseFloat(this.tempForm.value.temperature);
    const unit = this.tempForm.value.unit;

    if (unit === 'Celsius') {
      this.convertedTemp = (tempValue * 9/5) + 32; // Convert to Fahrenheit
      this.selectedUnit = 'Fahrenheit';
    } else {
      this.convertedTemp = (tempValue - 32) * 5/9; // Convert to Celsius
      this.selectedUnit = 'Celsius';
    }
  }
}
