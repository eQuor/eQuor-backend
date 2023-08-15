package com.eQuor.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lecturer {
    String fullName;
    String id;
    String email;
    String address;
    String userName;
    String password;
    String lectureCode;
    String propic;

    Staff approvedStaff;
}
