package com.eQuor.backend.models;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.annotation.PropertyName;
import com.google.firebase.database.Exclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff {
    String id;
    String Name;
    String Email;
    String Password;
    String Username;
    String Address;


    Admin ApprovedAdmin;

}
