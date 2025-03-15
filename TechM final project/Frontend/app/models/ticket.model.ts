export interface User {
  id: number;
  username: string;
  email: string;
  role: 'USER' | 'PROVIDER';
}

export interface Schedule {
  id: number;
  source: string;
  destination: string;
  departureTime: string;
  arrivalTime: string; // ✅ Added missing arrivalTime
  availableSeats: number;
  price: number;
  provider: User;
}

export interface ProviderSchedule extends Schedule {
  bookedUsers?: User[];
}

export interface Ticket {
  id: number;  // Matches API's "id"
  source: string;
  destination: string;
  travelDate: string; // Matches API's "travelDate"
  seatNo: string; // Matches API's "seatNo"
  price: number;
  bookingStatus: string; // Matches API's "bookingStatus"
  scheduleId?: number;  // Optional for reference
  providerId?: number;  // Optional for booking
}

export interface TicketSearch {
  source?: string;
  destination?: string;
  departureDate?: string;
  maxPrice?: number;
}

export interface TicketUpdate {
  seatNo: string; // ✅ Ensure correct naming
}

export interface SearchResult {
  providerId: number;
  schedules: Schedule[];
}
