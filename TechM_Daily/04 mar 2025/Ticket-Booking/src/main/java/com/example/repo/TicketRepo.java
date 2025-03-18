package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Ticket;

public interface TicketRepo extends CrudRepository<Ticket,String>{
}
