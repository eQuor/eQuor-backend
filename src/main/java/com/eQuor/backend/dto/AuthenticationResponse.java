package com.eQuor.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    Boolean status;
    String id;
    String role;
}
