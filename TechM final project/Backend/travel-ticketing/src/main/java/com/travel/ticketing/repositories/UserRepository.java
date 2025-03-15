package com.travel.ticketing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.ticketing.models.Role;
import com.travel.ticketing.models.Ticket;
import com.travel.ticketing.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);  // ✅ Ensure this method exists
    List<User> findById(User user);
    Optional<User> findByEmail(String email);
    List<User> findByRole(Role role);
}
