package com.example.reto3doctor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="message")
@NoArgsConstructor
@Getter
@Setter
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne()
    @JoinColumn(name = "id_doctor")
    @JsonIgnoreProperties({"messages", "reservations"})//reservations
    private DoctorModel doctor;

    @ManyToOne()
   @JoinColumn(name = "id_client")
    @JsonIgnoreProperties({"messages","reservations"})
   private ClientModel client;

}
