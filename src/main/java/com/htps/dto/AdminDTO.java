package com.htps.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
    private Long id;
    private String username;
    private String email;
    private String role; // You can add more details relevant to the Admin

    public AdminDTO(Long id, String username, String email, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
