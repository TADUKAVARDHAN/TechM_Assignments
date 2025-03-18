package com.example.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    @Size(min=10, max=10, message="Phone number must be 10 digits")
    private String phno;
    
    private String source;
    private String destination;
    
    private Date date;
}
