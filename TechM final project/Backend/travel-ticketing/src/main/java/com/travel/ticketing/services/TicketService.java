package com.travel.ticketing.services;

import com.travel.ticketing.dto.TicketResponseDTO;
import com.travel.ticketing.models.*;
import com.travel.ticketing.repositories.ScheduleRepository;
import com.travel.ticketing.repositories.TicketRepository;
import com.travel.ticketing.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public TicketService(ScheduleRepository scheduleRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
    }

   /* // ✅ Search for tickets based on source and destination
    public List<Ticket> searchTickets(String source, String destination) {
        return ticketRepository.findBySourceAndDestination(source, destination);
    }*/public List<Map<String, Object>> getProvidersWithSchedules(String source, String destination) {
        List<Schedule> schedules = scheduleRepository.findBySourceAndDestination(source, destination);
        
        // Group schedules by provider
        Map<Long, Map<String, Object>> groupedProviders = new HashMap<>();
        
        for (Schedule schedule : schedules) {
            Long providerId = schedule.getTransportProvider().getId();

            // If provider is not in the map, add it
            groupedProviders.putIfAbsent(providerId, new HashMap<>(Map.of(
                "providerId", providerId,
                "schedules", new ArrayList<Map<String, Object>>()
            )));

            // Add schedule details
            Map<String, Object> scheduleData = Map.of(
                "scheduleId", schedule.getId(),
                "departureTime", schedule.getDepartureTime(),
                "availableSeats", schedule.getAvailableSeats(),
                "price", schedule.getPrice()
            );

            ((List<Map<String, Object>>) groupedProviders.get(providerId).get("schedules")).add(scheduleData);
        }

        return new ArrayList<>(groupedProviders.values());
    }
    
    

 // ✅ Retrieve tickets booked by a specific user
    public List<TicketResponseDTO> getUserTickets(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ticketRepository.findByUser(user).stream()
                .map(ticket -> new TicketResponseDTO(
                        ticket.getId(),
                        ticket.getSource(),
                        ticket.getDestination(),
                        ticket.getTravelDate(),
                        ticket.getSeatNo(),
                        ticket.getPrice(),
                        ticket.getBookingStatus()
                ))
                .collect(Collectors.toList());
    }


    // ✅ Retrieve tickets booked with a specific provider
    public List<Ticket> getTicketsByProvider(Long providerId) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        return ticketRepository.findByProvider(provider);
    }

  /*  // ✅ Book a ticket (User selects transport provider)
    public Ticket bookTicket(Long userId, Long providerId, Ticket ticketDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Transport Provider not found"));

        if (!provider.isProvider()) {
            throw new RuntimeException("Selected provider is not valid.");
        }

        ticketDetails.setUser(user);
        ticketDetails.setProvider(provider);
        ticketDetails.setBookingDate(new Date());
        ticketDetails.setBookingStatus(BookingStatus.CONFIRMED);
        
        return ticketRepository.save(ticketDetails);
    }
    */
    
 // ✅ Update the return type to TicketResponseDTO
    public TicketResponseDTO bookTicket(Long userId, Long providerId, Long scheduleId, Ticket ticketDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        User provider = schedule.getTransportProvider();
        if (!provider.getId().equals(providerId)) {
            throw new RuntimeException("Invalid provider for this schedule");
        }

        if (schedule.getAvailableSeats() <= 0) {
            throw new RuntimeException("No available seats for this schedule.");
        }

        // ✅ Check if the seat was previously cancelled and allow rebooking
        boolean isSeatBooked = ticketRepository.existsByScheduleIdAndSeatNo(scheduleId, ticketDetails.getSeatNo());
        if (isSeatBooked) {
            Ticket existingTicket = ticketRepository.findByScheduleIdAndSeatNo(scheduleId, ticketDetails.getSeatNo())
                    .orElse(null);
            if (existingTicket != null && existingTicket.getBookingStatus() == BookingStatus.CANCELLED) {
                // ✅ Allow rebooking of cancelled seat
                existingTicket.setUser(user);
                existingTicket.setBookingStatus(BookingStatus.CONFIRMED);
                existingTicket.setBookingDate(new Date());
                schedule.setAvailableSeats(schedule.getAvailableSeats() - 1);
                scheduleRepository.save(schedule);
                ticketRepository.save(existingTicket);
                return new TicketResponseDTO(
                        existingTicket.getId(),
                        existingTicket.getSource(),
                        existingTicket.getDestination(),
                        existingTicket.getTravelDate(),
                        existingTicket.getSeatNo(),
                        existingTicket.getPrice(),
                        existingTicket.getBookingStatus()
                );
            }
            throw new RuntimeException("Seat " + ticketDetails.getSeatNo() + " is already booked.");
        }

        // ✅ Set ticket details for new booking
        ticketDetails.setUser(user);
        ticketDetails.setProvider(provider);
        ticketDetails.setSchedule(schedule);
        ticketDetails.setSource(schedule.getSource());
        ticketDetails.setDestination(schedule.getDestination());
        ticketDetails.setTravelDate(schedule.getDepartureTime().toLocalDate());
        ticketDetails.setPrice(BigDecimal.valueOf(schedule.getPrice()));

        // 🔥 **Fix: Set Transport Type to `BUS`**
        ticketDetails.setTransportType(TransportType.BUS);

        ticketDetails.setBookingStatus(BookingStatus.CONFIRMED);

        schedule.setAvailableSeats(schedule.getAvailableSeats() - 1);
        scheduleRepository.save(schedule);
        Ticket savedTicket = ticketRepository.save(ticketDetails);

        return new TicketResponseDTO(
                savedTicket.getId(),
                savedTicket.getSource(),
                savedTicket.getDestination(),
                savedTicket.getTravelDate(),
                savedTicket.getSeatNo(),
                savedTicket.getPrice(),
                savedTicket.getBookingStatus()
        );
    }



    
    

    public TicketResponseDTO updateTicket(Long userId, Long ticketId, Ticket updatedDetails) {
        // ✅ Fetch the ticket
        Ticket existingTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        // ✅ Ensure the logged-in user is the owner of the ticket
        if (!existingTicket.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized: You can only update your own ticket.");
        }

        // ❌ Prevent updates for CANCELLED tickets
        if (existingTicket.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Cannot update a cancelled ticket.");
        }

        // ✅ Allow modification of seat number only
        if (!existingTicket.getSeatNo().equals(updatedDetails.getSeatNo())) {
            // ❌ Check if the new seat is already booked
            boolean isSeatBooked = ticketRepository.existsByScheduleIdAndSeatNo(
                    existingTicket.getSchedule().getId(), updatedDetails.getSeatNo());

            if (isSeatBooked) {
                throw new RuntimeException("Seat " + updatedDetails.getSeatNo() + " is already booked.");
            }

            // ✅ Change seat number if available
            existingTicket.setSeatNo(updatedDetails.getSeatNo());
        } else {
            throw new RuntimeException("Only seat number can be modified.");
        }

        // ✅ Save and return response DTO
        Ticket savedTicket = ticketRepository.save(existingTicket);
        return new TicketResponseDTO(
                savedTicket.getId(),
                savedTicket.getSource(),
                savedTicket.getDestination(),
                savedTicket.getTravelDate(),
                savedTicket.getSeatNo(),
                savedTicket.getPrice(),
                savedTicket.getBookingStatus()
        );
    }



    
    

    public void cancelBooking(Long userId, Long ticketId) {
        // ✅ Fetch the ticket
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        // ✅ Ensure the logged-in user is the owner of the ticket
        if (!ticket.getUser().getId().equals(userId)) {
            throw new RuntimeException("Unauthorized: You can only cancel your own ticket.");
        }

        // ❌ Prevent duplicate cancellation
        if (ticket.getBookingStatus() == BookingStatus.CANCELLED) {
            throw new RuntimeException("Ticket is already cancelled.");
        }

        // ✅ Increase available seats in the schedule
        Schedule schedule = ticket.getSchedule();
        schedule.setAvailableSeats(schedule.getAvailableSeats() + 1);
        scheduleRepository.save(schedule);

        // ✅ Mark the ticket as cancelled
        ticket.setBookingStatus(BookingStatus.CANCELLED);
        ticketRepository.save(ticket);
        
     // ✅ Ensure seat is removed from booked seats
        ticket.setSeatNo(null);
        ticketRepository.save(ticket);
    }



    // ✅ Retrieve all tickets (ADMIN Feature)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
