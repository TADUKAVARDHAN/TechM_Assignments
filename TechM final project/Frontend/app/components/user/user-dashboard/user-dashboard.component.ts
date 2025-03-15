import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TicketService } from '../../../services/ticket.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface SearchResult {
  providerId: number;
  schedules: {
    scheduleId: number;
    availableSeats: number;
    price: number;
    departureTime: string;
  }[];
}

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss'],
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule, HttpClientModule],
  providers: [TicketService]
})
export class UserDashboardComponent implements OnInit {
  searchForm: FormGroup;
  searchResults: SearchResult[] = [];
  userTickets: any[] = [];
  errorMessage = '';
  successMessage = '';
  searchedSource = '';
  searchedDestination = '';

  constructor(
    private ticketService: TicketService,
    private fb: FormBuilder
  ) {
    this.searchForm = this.fb.group({
      source: ['', Validators.required],
      destination: ['', Validators.required],
      departureDate: [''],
      maxPrice: ['']
    });
  }

  ngOnInit(): void {
    this.loadUserTickets();
  }

  // ✅ Load booked tickets for the logged-in user
  loadUserTickets(): void {
    this.ticketService.getUserTickets().subscribe({
      next: (tickets) => {
        this.userTickets = tickets.map(ticket => ({
          ...ticket,
          newSeatNo: ticket.seatNo // ✅ Temporary property for updating seats
        }));
      },
      error: (error) => {
        this.errorMessage = 'Failed to load tickets';
        console.error('Error loading tickets:', error);
      }
    });
  }

  // ✅ Search for available tickets (fixed structure)
  searchTickets(): void {
    if (this.searchForm.valid) {
      this.searchedSource = this.searchForm.value.source;
      this.searchedDestination = this.searchForm.value.destination;

      this.ticketService.searchTickets(this.searchForm.value).subscribe({
        next: (results: SearchResult[]) => {
          this.searchResults = results;
          this.successMessage = `✅ Found ${results.length} provider(s)`;
          this.clearErrorMessage();
        },
        error: (error) => {
          this.errorMessage = '⚠️ No tickets found.';
          console.error('Error searching tickets:', error);
        }
      });
    }
  }

  // ✅ Book a ticket (fixed providerId & scheduleId retrieval)
  bookTicket(providerId: number, scheduleId: number, seatNo: string): void {
    if (!seatNo || !providerId || !scheduleId) {
      this.errorMessage = '⚠️ Missing details! Check providerId, scheduleId, and seatNo.';
      return;
    }

    this.ticketService.bookTicket(providerId, scheduleId, seatNo).subscribe({
      next: () => {
        this.successMessage = '🎟️ Ticket booked successfully!';
        this.loadUserTickets();
        this.clearErrorMessage();
      },
      error: (error) => {
        this.errorMessage = '❌ Error booking ticket!';
        console.error('Error booking ticket:', error);
      }
    });
  }

  // ✅ Update seat number
  updateTicket(ticketId: number, seatNo: string): void {
    if (!seatNo) {
      this.errorMessage = '⚠️ Please enter a new seat number!';
      return;
    }

    this.ticketService.updateTicket(ticketId, seatNo).subscribe({
      next: () => {
        this.successMessage = '✅ Seat updated successfully!';
        this.loadUserTickets();
        this.clearErrorMessage();
      },
      error: (error) => {
        this.errorMessage = '❌ Error updating seat!';
        console.error('Error updating seat:', error);
      }
    });
  }

  // ✅ Cancel a ticket
  cancelTicket(ticketId: number): void {
    this.ticketService.cancelTicket(ticketId).subscribe({
      next: () => {
        this.successMessage = '🚫 Ticket cancelled successfully!';
        this.loadUserTickets();
        this.clearErrorMessage();
      },
      error: (error) => {
        this.errorMessage = '❌ Error cancelling ticket!';
        console.error('Error cancelling ticket:', error);
      }
    });
  }

  clearMessages(): void {
    this.errorMessage = '';
    this.successMessage = '';
  }

  private clearErrorMessage(): void {
    this.errorMessage = '';
  }
}
