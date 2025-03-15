import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Ticket, TicketSearch, TicketUpdate } from '../models/ticket.model';

// ✅ Define SearchResult interface
interface SearchResult {
  providerId: number;
  schedules: {
    scheduleId: number;
    availableSeats: number;
    price: number;
    departureTime: string;
  }[];
}

@Injectable({
  providedIn: 'root'
})
export class TicketService {
  private readonly apiUrl = environment.apiUrl; // Ensure it's correct

  constructor(private http: HttpClient) {}

  // ✅ Helper Method: Get Auth Headers with JWT Token
  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`, // ✅ Attach JWT Token
      'Content-Type': 'application/json'
    });
  }

  // ✅ FIXED: Corrected API URL (Removed extra `/api`)
  getUserTickets(): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${this.apiUrl}/tickets/user`, { headers: this.getAuthHeaders() });
  }

  // ✅ Search Tickets API - Returns `SearchResult[]`
  searchTickets(search: TicketSearch): Observable<SearchResult[]> {
    return this.http.get<SearchResult[]>(`${this.apiUrl}/tickets/search`, {
      headers: this.getAuthHeaders(),
      params: { ...search }
    });
  }

  bookTicket(providerId: number, scheduleId: number, seatNo: string): Observable<Ticket> {
    return this.http.post<Ticket>(`${this.apiUrl}/tickets/book/${providerId}/${scheduleId}`, { seatNo }, { headers: this.getAuthHeaders() });
  }

  updateTicket(ticketId: number, seatNo: string): Observable<Ticket> {
    const update: TicketUpdate = { seatNo };
    return this.http.put<Ticket>(`${this.apiUrl}/tickets/update/${ticketId}`, update, { headers: this.getAuthHeaders() });
  }

  cancelTicket(ticketId: number): Observable<{ message: string }> {
    return this.http.delete<{ message: string }>(`${this.apiUrl}/tickets/cancel/${ticketId}`, { headers: this.getAuthHeaders() });
  }
}
