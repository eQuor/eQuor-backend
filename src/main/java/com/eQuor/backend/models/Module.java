package com.eQuor.backend.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"module\"")
public class Module {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "semester")
    Integer semester;
    @Column(name = "year")
    Integer year;


    @Column(name = "managed_staff")
    String managedStaff;
    @PrePersist
    public void prePersist() {
        this.managedStaff = "2021STF021";
    }

}
