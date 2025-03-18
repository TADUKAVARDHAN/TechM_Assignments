import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
  id: string = '';
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  phno: string = '';
  source: string = '';
  destination: string = '';
  date: string = '';

  constructor(private http: HttpClient) {}

  Save() {
    const booking = {
        id: this.id,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        phno: this.phno,
        source: this.source,
        destination: this.destination,
        date: this.date
    };

    console.log("🔹 Sending Booking Data:", booking);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    this.http.post("http://localhost:8383/booking", booking);
    alert("Booking is successful")
}


  ngOnInit(): void {}
}
