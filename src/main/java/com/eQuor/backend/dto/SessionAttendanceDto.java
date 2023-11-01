package com.eQuor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SessionAttendanceDto {
    String id;

    String name;

    String email;

    String username;

    String address;
}
