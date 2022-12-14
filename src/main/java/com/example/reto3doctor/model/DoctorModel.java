package com.example.reto3doctor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.List;

@Entity
@Table (name="doctor")
@NoArgsConstructor
@Getter
@Setter
public class DoctorModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String department;
    private Integer year; //graduate_year
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_specialty") //
    @JsonIgnoreProperties("doctors")
    private SpecialtyModel specialty; //Model


    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<MessageModel> messages;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnoreProperties({"doctor", "client"})
    private List<ReservationModel> reservations;

}
