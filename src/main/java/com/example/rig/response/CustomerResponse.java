package com.example.rig.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
