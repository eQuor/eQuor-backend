package com.eQuor.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin {
    private String id;
    private String Name;

    private String Password;

    String Address;
    String Email;

    String Username;
}
