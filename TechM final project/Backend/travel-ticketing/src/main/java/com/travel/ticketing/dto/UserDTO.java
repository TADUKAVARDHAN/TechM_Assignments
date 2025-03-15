package com.travel.ticketing.dto;

import com.travel.ticketing.models.User;

public class UserDTO {
    private Long id;
    private String username;
    private String email;

    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail());
    }

    // ✅ Getters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
}
