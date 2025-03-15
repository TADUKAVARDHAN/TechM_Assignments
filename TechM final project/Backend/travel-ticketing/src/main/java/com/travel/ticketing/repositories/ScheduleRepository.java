package com.travel.ticketing.repositories;

import com.travel.ticketing.models.BookingStatus;
import com.travel.ticketing.models.Schedule;
import com.travel.ticketing.models.Ticket;
import com.travel.ticketing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	List<Schedule> findBySourceAndDestination(String source, String destination);
	  List<Schedule> findByProvider(User provider);
	List<Schedule> findByprovider(User provider);
	@Query("SELECT s FROM Schedule s WHERE s.provider.id = :providerId")
	List<Schedule> findByProviderId(@Param("providerId") Long providerId);
	

	
}