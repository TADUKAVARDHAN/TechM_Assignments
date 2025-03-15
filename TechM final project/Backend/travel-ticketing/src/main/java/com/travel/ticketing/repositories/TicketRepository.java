package com.travel.ticketing.repositories;

import com.travel.ticketing.models.Ticket;
import com.travel.ticketing.models.User;
import com.travel.ticketing.models.BookingStatus;
import com.travel.ticketing.models.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findBySourceAndDestination(String source, String destination);
    List<Ticket> findByUser(User user);
    List<Ticket> findById(User user);
    List<Ticket> findByProvider(User provider);
    List<Ticket> findByUserAndBookingStatus(User user, BookingStatus status);
    @Query("SELECT DISTINCT t.user FROM Ticket t WHERE t.schedule IN :schedules")
    List<User> findDistinctUsersBySchedules(@Param("schedules") List<Schedule> schedules);
    // ✅ Add this method to fetch ticket by schedule ID & seat number
    Optional<Ticket> findByScheduleIdAndSeatNo(Long scheduleId, String seatNo);
    
    boolean existsByScheduleIdAndSeatNo(Long scheduleId, String seatNo);
    List<Ticket> findByScheduleAndBookingStatus(Schedule schedule, BookingStatus bookingStatus);
    // ✅ Count all CONFIRMED tickets for a schedule
    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.schedule = :schedule AND t.bookingStatus = 'CONFIRMED'")
    int countConfirmedTicketsForSchedule(@Param("schedule") Schedule schedule);
}

