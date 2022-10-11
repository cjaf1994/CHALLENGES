package com.example.reto3doctor.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class ClientModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<MessageModel> messages;

    @OneToMany(mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<ReservationModel> reservations;


}
