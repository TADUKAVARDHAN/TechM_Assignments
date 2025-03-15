package com.travel.ticketing.dto;

import com.travel.ticketing.models.BookingStatus;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TicketResponseDTO {
    private Long id;
    private String source;
    private String destination;
    private LocalDate travelDate;
    private String seatNo;
    private BigDecimal price;
    private BookingStatus bookingStatus;

    // Constructor
    public TicketResponseDTO(Long id, String source, String destination, LocalDate travelDate, String seatNo, BigDecimal price, BookingStatus bookingStatus) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.seatNo = seatNo;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getTravelDate() { return travelDate; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }

    public String getSeatNo() { return seatNo; }
    public void setSeatNo(String seatNo) { this.seatNo = seatNo; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public BookingStatus getBookingStatus() { return bookingStatus; }
    public void setBookingStatus(BookingStatus bookingStatus) { this.bookingStatus = bookingStatus; }
}
