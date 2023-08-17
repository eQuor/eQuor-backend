package com.eQuor.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    String id;
    Integer indexNo;
    String address;
    String email;
    String userName;
    String password;
    String propic;
    String fullName;
    String regNo;

    Staff approvedStaff;
}
