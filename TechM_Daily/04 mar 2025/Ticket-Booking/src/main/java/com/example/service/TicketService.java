package com.example.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.TicketException;
import com.example.model.Ticket;
import com.example.repo.TicketRepo;

@Service
public class TicketService {
    @Autowired
    private TicketRepo repo;

    public Iterable<Ticket> allBookings(){
        return repo.findAll();
    }

    public Optional<Ticket> Booking(String id) throws TicketException{
        if(repo.existsById(id)) {
            return repo.findById(id);
        } else {
            throw new TicketException("No ticket found with ID: " + id);
        }
    }

    public String addBooking(Ticket t) {
        System.out.println("🔹 Saving Booking: " + t);
        repo.save(t);
        return "Booking saved successfully!";
    }
    public String updateBooking(String id,Ticket t) throws TicketException {
    	if(repo.existsById(id)) {
	    	t.setId(id);
	    	repo.save(t);
	    	return "Booking is updated succesfully";
    	}
    	else {
    		throw new TicketException("No ticket found with ID: " + id);
    	}
    }
    public String deleteBooking(String id) throws TicketException{
    	if(repo.existsById(id)) {
    		repo.deleteById(id);
    		return "Booking is deleted successfully";
    	}
    	else {
    		throw new TicketException("No ticket found with ID: " + id);
    	}
    }
}
