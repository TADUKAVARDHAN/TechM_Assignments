package com.travel.ticketing.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "id", nullable = false)
    private User provider; // ✅ Store the provider who owns this schedule
    
    
    
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore  // ✅ Prevents recursion issue
    private List<Ticket> tickets;  // All booked tickets for this schedule
    
    
    
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    private int availableSeats;
    private double price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getTransportProvider() {
		return provider;
	}
	public void setTransportProvider(User transportProvider) {
		this.provider = transportProvider;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	// ✅ Getter for tickets
	public List<Ticket> getTickets() {
	    return tickets;
	}
	
	// ✅ Manually add setTickets() method
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
