package com.eQuor.backend.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class APIRequest {
    String id;
    String Email;
    String Description;
    String FullName;
    String NIC;

    Integer AcceptStatus;

    Admin ApprovedAdmin;
}
