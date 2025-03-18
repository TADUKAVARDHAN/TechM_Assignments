package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.TicketException;
import com.example.model.Ticket;
import com.example.service.TicketService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TicketController {
	@Autowired
	private TicketService t;
	@CrossOrigin
	@GetMapping("/booking")
	public Iterable<Ticket> getallTickets(){
		return t.allBookings();
	}
	@CrossOrigin
	@GetMapping("/booking/{id}")
	public ResponseEntity<Optional<Ticket>> getaTicket(@PathVariable String id) throws TicketException{
        return ResponseEntity.ok(t.Booking(id));
	}
	@CrossOrigin
	@PostMapping("/booking")
	public ResponseEntity<String> setticket(@RequestBody Ticket tick){
		return ResponseEntity.ok(t.addBooking(tick));
	}
	@CrossOrigin
	@PutMapping("/booking/{id}")
	public ResponseEntity<String> updateticket(@PathVariable String id,@RequestBody Ticket tick) throws TicketException{
		return ResponseEntity.ok(t.updateBooking(id, tick));
	}
	@CrossOrigin
	@DeleteMapping("/booking/{id}")
	public ResponseEntity<String> deleteaTicket(@PathVariable String id) throws TicketException{
		return ResponseEntity.ok(t.deleteBooking(id));
	}
}
