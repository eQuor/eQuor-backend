package com.eQuor.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentAttendanceStatDto {

    Integer totalSessionsForModule;
    Integer totalAttendedSessions;
}
