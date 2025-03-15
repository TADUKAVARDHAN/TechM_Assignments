package com.travel.ticketing.controllers;

import com.travel.ticketing.dto.TicketResponseDTO;
import com.travel.ticketing.models.Ticket;
import com.travel.ticketing.models.User;
import com.travel.ticketing.services.TicketService;
import com.travel.ticketing.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final UserRepository userRepository;

    public TicketController(TicketService ticketService, UserRepository userRepository) {
        this.ticketService = ticketService;
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> searchProvidersWithSchedules(
            @RequestParam String source,
            @RequestParam String destination) {
        return ResponseEntity.ok(ticketService.getProvidersWithSchedules(source, destination));
    }

 // ✅ Get all tickets booked by a user (Fixed issue)
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<List<TicketResponseDTO>> getUserTickets(@AuthenticationPrincipal UserDetails userDetails) {
        // ✅ Ensure the authenticated user is fetching their own tickets
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(ticketService.getUserTickets(user.getId()));
    }
    /*

 // ✅ Book a new ticket (Fixed providerId issue)
    @PostMapping("/book/{userId}/{providerId}")
    public ResponseEntity<?> bookTicket(@PathVariable Long userId, @PathVariable Long providerId, @RequestBody Ticket ticketDetails) {
        return ResponseEntity.ok(ticketService.bookTicket(userId, providerId, ticketDetails));
    }
    
    */

 
 // ✅ Modify an existing ticket (Allow only seat number change)
    @PreAuthorize("hasRole('USER')")
    @PutMapping("/update/{ticketId}")
    public ResponseEntity<TicketResponseDTO> updateTicket(
            @PathVariable Long ticketId, 
            @RequestBody Ticket updatedDetails, 
            @AuthenticationPrincipal UserDetails userDetails) {
        
        // ✅ Get the logged-in user from JWT token
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Ensure the user is modifying only their own ticket
        TicketResponseDTO updatedTicket = ticketService.updateTicket(user.getId(), ticketId, updatedDetails);

        return ResponseEntity.ok(updatedTicket);
    }

 // ✅ Cancel a ticket booking (Only the owner can cancel)
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/cancel/{ticketId}")
    public ResponseEntity<String> cancelBooking(
            @PathVariable Long ticketId, 
            @AuthenticationPrincipal UserDetails userDetails) {

        // ✅ Get the logged-in user from JWT token
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Ensure the user is canceling their own ticket
        ticketService.cancelBooking(user.getId(), ticketId);

        return ResponseEntity.ok("Ticket cancelled successfully.");
    }


    // ✅ Get all tickets (Admin Only)
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
    
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/book/{providerId}/{scheduleId}")
    public ResponseEntity<TicketResponseDTO> bookTicket(
            @PathVariable Long providerId,
            @PathVariable Long scheduleId,
            @RequestBody Ticket ticketDetails,
            @AuthenticationPrincipal UserDetails userDetails) {  // ✅ Fetch authenticated user from JWT

        // ✅ Get the logged-in user
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(ticketService.bookTicket(user.getId(), providerId, scheduleId, ticketDetails));
    }


    
    
}
