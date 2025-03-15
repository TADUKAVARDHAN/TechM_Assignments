import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ScheduleService } from '../../../services/schedule.service';
import { ProviderSchedule, User } from '../../../models/ticket.model';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-provider-dashboard',
  templateUrl: './provider-dashboard.component.html',
  styleUrls: ['./provider-dashboard.component.scss'],
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, HttpClientModule],
  providers: [ScheduleService]
})
export class ProviderDashboardComponent implements OnInit {
  scheduleForm: FormGroup;
  schedules: ProviderSchedule[] = [];
  selectedScheduleUsers: User[] = [];
  providerUsername: string = ''; // ✅ Fetched from localStorage
  errorMessage = '';
  successMessage = '';
  selectedScheduleId: number | null = null;

  constructor(
    private fb: FormBuilder,
    private scheduleService: ScheduleService,
    private router: Router
  ) {
    this.scheduleForm = this.fb.group({
      source: ['', Validators.required],
      destination: ['', Validators.required],
      departureTime: ['', Validators.required],
      arrivalTime: ['', Validators.required],
      availableSeats: ['', [Validators.required, Validators.min(1)]],
      price: ['', [Validators.required, Validators.min(0)]]
    });
  }

  ngOnInit(): void {
    this.loadSchedules();
    this.providerUsername = this.getProviderUsername();
  }

  getProviderUsername(): string {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user).username : 'Provider';
  }

  loadSchedules(): void {
    this.scheduleService.getProviderSchedules().subscribe({
      next: (schedules) => {
        this.schedules = schedules;
      },
      error: (error: Error) => {
        this.errorMessage = 'Failed to load schedules';
        console.error('Error loading schedules:', error);
      }
    });
  }

  addSchedule(): void {
    if (this.scheduleForm.valid) {
      const schedule = {
        ...this.scheduleForm.value,
        departureTime: new Date(this.scheduleForm.value.departureTime).toISOString(),
        arrivalTime: new Date(this.scheduleForm.value.arrivalTime).toISOString()
      };

      this.scheduleService.addSchedule(schedule).subscribe({
        next: (response) => {
          this.successMessage = response.message;
          this.scheduleForm.reset();
          this.loadSchedules();
        },
        error: (error: Error) => {
          this.errorMessage = 'Failed to add schedule';
          console.error('Error adding schedule:', error);
        }
      });
    }
  }

  viewBookedUsers(scheduleId: number): void {
    this.selectedScheduleId = scheduleId;
    this.scheduleService.getBookedUsers(scheduleId).subscribe({
      next: (response) => {
        this.selectedScheduleUsers = response.confirmedUsers;
      },
      error: (error: Error) => {
        this.errorMessage = 'Failed to load booked users';
        console.error('Error loading booked users:', error);
      }
    });
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  clearMessages(): void {
    this.errorMessage = '';
    this.successMessage = '';
  }
}
