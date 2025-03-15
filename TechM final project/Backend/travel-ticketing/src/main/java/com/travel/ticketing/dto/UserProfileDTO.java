package com.travel.ticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserProfileDTO {
    private Long id;
    private String username;
    private String email;
    private String role;
  
}
