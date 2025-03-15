package com.travel.ticketing.controllers;

import com.travel.ticketing.models.User;
import com.travel.ticketing.repositories.UserRepository;
import com.travel.ticketing.models.Role;
import com.travel.ticketing.models.Schedule;
import com.travel.ticketing.services.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserRepository userRepository;
    
    public ScheduleController(ScheduleService scheduleService,UserRepository userRepository) {
        this.scheduleService = scheduleService;
        this.userRepository = userRepository;
    }
    
    @PreAuthorize("hasRole('PROVIDER')")
    @PostMapping("/add")
    public ResponseEntity<?> addSchedule(
            @RequestBody Schedule schedule,
            @AuthenticationPrincipal UserDetails userDetails) {

        // ✅ Get the logged-in provider from JWT token
        User provider = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        // ✅ Ensure the logged-in user is a PROVIDER
        if (!provider.getRole().equals(Role.PROVIDER)) {
            throw new RuntimeException("Unauthorized: Only providers can add schedules.");
        }

        // ✅ Add schedule for the authenticated provider
        scheduleService.addSchedule(provider.getId(), schedule);

        // ✅ Return a simple success message
        return ResponseEntity.ok(Map.of("message", "Schedule added successfully"));
    }

    
    
    @PreAuthorize("hasRole('PROVIDER')")
    @GetMapping("/provider")
    public ResponseEntity<List<Schedule>> getSchedulesByProvider(@AuthenticationPrincipal UserDetails userDetails) {
        // ✅ Ensure the authenticated provider is fetching their own schedules
        User provider = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        List<Schedule> schedules = scheduleService.getSchedulesByProvider(provider.getId());
        return ResponseEntity.ok(schedules);
    }



 // ✅ Get all available schedules for a given source and destination
    @GetMapping("/search")
    public ResponseEntity<List<Schedule>> searchSchedules(
            @RequestParam String source,
            @RequestParam String destination) {
        return ResponseEntity.ok(scheduleService.searchSchedules(source, destination));
    }
    
    
    @PreAuthorize("hasRole('PROVIDER')")
    @PutMapping("/update/{scheduleId}")
    public ResponseEntity<?> updateSchedule(@PathVariable Long scheduleId, @RequestBody Schedule updatedSchedule) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleId, updatedSchedule));
    }
    
    @PreAuthorize("hasRole('PROVIDER')")
    @DeleteMapping("/delete/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.ok("Schedule deleted successfully.");
    }
    
    
 // ✅ Get All Users Who Booked a Provider's Schedule
    @PreAuthorize("hasRole('PROVIDER')")
    @GetMapping("/schedule/{scheduleId}/users")
    public ResponseEntity<Map<String, Object>> getUsersAndSeatsBySchedule(
            @PathVariable Long scheduleId,
            @AuthenticationPrincipal UserDetails userDetails) {

        // ✅ Get the logged-in provider
        User provider = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        return ResponseEntity.ok(scheduleService.getUsersAndSeatsBySchedule(scheduleId, provider.getId()));
    }

    
    
}
