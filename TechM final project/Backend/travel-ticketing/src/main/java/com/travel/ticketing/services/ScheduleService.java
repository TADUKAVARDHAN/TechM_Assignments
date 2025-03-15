package com.travel.ticketing.services;

import com.travel.ticketing.dto.UserDTO;
import com.travel.ticketing.models.BookingStatus;
import com.travel.ticketing.models.Role;
import com.travel.ticketing.models.Schedule;
import com.travel.ticketing.models.User;
import com.travel.ticketing.repositories.ScheduleRepository;
import com.travel.ticketing.repositories.UserRepository;
import com.travel.ticketing.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import com.travel.ticketing.models.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;  // ✅ Fetch provider from User table
    private final TicketRepository ticketRepository;
    
    public ScheduleService(ScheduleRepository scheduleRepository, TicketRepository ticketRepository, UserRepository userRepository) {
    	this.scheduleRepository = scheduleRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    // ✅ Add a schedule for a provider (User with role PROVIDER)
    public Schedule addSchedule(Long providerId, Schedule schedule) {
        // ✅ Fetch the provider and ensure they have the PROVIDER role
        User provider = userRepository.findById(providerId)
                .filter(user -> user.getRole().equals(Role.PROVIDER))  // ✅ Ensure user is a provider
                .orElseThrow(() -> new RuntimeException("Provider not found or not authorized"));

        // ✅ Assign provider to the schedule
        schedule.setTransportProvider(provider);  

        // ✅ Save and return the new schedule
        return scheduleRepository.save(schedule);
    }


   
    
    // ✅ Get all schedules for a specific provider
    public List<Schedule> getSchedulesByProvider(Long providerId) {
        User provider = userRepository.findById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return scheduleRepository.findByProvider(provider).stream()
                .map(schedule -> {
                    Schedule scheduleDto = new Schedule();
                    scheduleDto.setId(schedule.getId());
                    scheduleDto.setSource(schedule.getSource());
                    scheduleDto.setDestination(schedule.getDestination());
                    scheduleDto.setDepartureTime(schedule.getDepartureTime());
                    scheduleDto.setArrivalTime(schedule.getArrivalTime());
                    scheduleDto.setAvailableSeats(schedule.getAvailableSeats());
                    scheduleDto.setPrice(schedule.getPrice());
                    return scheduleDto;
                })
                .collect(Collectors.toList());
    }





    // ✅ Search schedules by source & destination
 // ✅ Fetch schedules based on source and destination
    public List<Schedule> searchSchedules(String source, String destination) {
        return scheduleRepository.findBySourceAndDestination(source, destination);
    }


    // ✅ Update an existing schedule
    public Schedule updateSchedule(Long scheduleId, Schedule updatedSchedule) {
        Schedule existingSchedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        existingSchedule.setSource(updatedSchedule.getSource());
        existingSchedule.setDestination(updatedSchedule.getDestination());
        existingSchedule.setDepartureTime(updatedSchedule.getDepartureTime());
        existingSchedule.setArrivalTime(updatedSchedule.getArrivalTime());
        existingSchedule.setAvailableSeats(updatedSchedule.getAvailableSeats());
        existingSchedule.setPrice(updatedSchedule.getPrice());

        return scheduleRepository.save(existingSchedule);
    }

    // ✅ Delete a schedule
    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }
    
 // ✅ Get users & total booked seats for a specific schedule
    public Map<String, Object> getUsersAndSeatsBySchedule(Long scheduleId, Long providerId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        // ✅ Ensure provider is authorized
        if (!schedule.getTransportProvider().getId().equals(providerId)) {
            throw new RuntimeException("Access denied: You are not the provider of this schedule.");
        }

        // ✅ Fetch confirmed users and map them to DTO
        List<UserDTO> confirmedUsers = ticketRepository.findByScheduleAndBookingStatus(schedule, BookingStatus.CONFIRMED)
                .stream()
                .map(ticket -> UserDTO.fromUser(ticket.getUser())) // Convert User → UserDTO
                .distinct()
                .collect(Collectors.toList());

        // ✅ Get total booked seats
        int totalBookedSeats = ticketRepository.countConfirmedTicketsForSchedule(schedule);

        // ✅ Return users & seat count in a map
        Map<String, Object> response = new HashMap<>();
        response.put("scheduleId", scheduleId);
        response.put("providerId", providerId);
        response.put("totalBookedSeats", totalBookedSeats);
        response.put("confirmedUsers", confirmedUsers);

        return response;
    }
    



    
}
