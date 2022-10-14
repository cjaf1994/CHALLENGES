package com.example.reto3doctor.Repository.crudrepository;


import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer>{

    @Query("SELECT c.client, COUNT (c.client)  FROM ReservationModel AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countReservationModelByClient();
    //query methods,        primer para la fecha de inicio que se filtra y el segundo en el que termina agarrando los startDate
    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date startFinish);

    public List<ReservationModel> findAllByStatus(String status);


}
