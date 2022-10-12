package com.example.reto3doctor.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="reservation")
@NoArgsConstructor
@Getter
@Setter
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private LocalDate startDate;
    private LocalDate devolutionDate;
    private String status= "created";
    @ManyToOne()
    @JoinColumn(name = "id_doctor")
    @JsonIgnoreProperties("reservations")
    private DoctorModel doctor;

    @ManyToOne()
    @JoinColumn(name = "id_client")
    @JsonIgnoreProperties({"reservations","messages"})//reservation
    private ClientModel client;

    //@OneToMany(mappedBy = "reservation")
    //@JsonIgnoreProperties("reservation")
    //private List<ScoreModel> scores;

    @OneToOne(mappedBy = "reservations")
    @JsonIgnoreProperties("reservations")
    private ScoreModel score;


}
