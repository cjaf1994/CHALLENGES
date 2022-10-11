package com.example.reto3doctor.Repository.crudrepository;


import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer>{

}
