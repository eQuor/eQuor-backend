package com.eQuor.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MarkAttendanceRequestDto {
    Integer sessionId;

    private List<Integer> codes;
}
