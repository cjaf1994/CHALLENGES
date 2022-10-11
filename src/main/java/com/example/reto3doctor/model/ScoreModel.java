package com.example.reto3doctor.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "score")
@NoArgsConstructor
@Getter
@Setter
public class ScoreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer Score;
    private String messageScore;

    //@ManyToOne()
    //@JoinColumn(name = "reservation_id")
    //@JsonIgnoreProperties("scores")
    //private ReservationModel reservation;

    @OneToOne
    @JsonIgnoreProperties("score")
    private ReservationModel reservations;

}
