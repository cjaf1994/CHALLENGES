package com.example.reto3doctor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="specialty")
@NoArgsConstructor
@Getter
@Setter

public class SpecialtyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer id;
        private String name;
        private String description;

    @OneToMany(mappedBy = "specialty") //Model
    @JsonIgnoreProperties("specialty")
    private List<DoctorModel> doctors;

}
