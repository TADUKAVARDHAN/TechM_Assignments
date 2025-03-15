import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Schedule, User } from '../models/ticket.model';
import { environment } from '../../environments/environment';

interface AddScheduleRequest {
  source: string;
  destination: string;
  departureTime: string;
  arrivalTime: string;
  availableSeats: number;
  price: number;
}

interface BookedUsersResponse {
  confirmedUsers: User[];
  totalBookedSeats: number;
}

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  private readonly apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  // ✅ Get JWT token from localStorage
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    if (!token) {
      console.warn("⚠️ No token found! Unauthorized access might occur.");
    }
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  }

  // ✅ Add a Schedule (Only for Providers)
  addSchedule(schedule: AddScheduleRequest): Observable<{ message: string }> {
    return this.http.post<{ message: string }>(
      `${this.apiUrl}/schedules/add`, 
      schedule, 
      { headers: this.getAuthHeaders() }
    );
  }

  // ✅ Get All Schedules Created by a Provider
  getProviderSchedules(): Observable<Schedule[]> {
    return this.http.get<Schedule[]>(
      `${this.apiUrl}/schedules/provider`, 
      { headers: this.getAuthHeaders() }
    );
  }

  // ✅ Get Users Who Have Booked a Particular Schedule
  getBookedUsers(scheduleId: number): Observable<BookedUsersResponse> {
    return this.http.get<BookedUsersResponse>(
      `${this.apiUrl}/schedules/schedule/${scheduleId}/users`, 
      { headers: this.getAuthHeaders() }
    );
  }
}
