package com.eQuor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentSessionDetails {

    Integer id;
    Integer requirement;
    String start_time;
    String end_time;
    String session_name;
}
