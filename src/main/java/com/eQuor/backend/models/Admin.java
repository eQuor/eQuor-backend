package com.eQuor.backend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Admin extends User{

    String Address;
    String Email;

    String Username;
}
