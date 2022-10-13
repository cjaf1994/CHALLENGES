package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.SpecialtyModel;
import com.example.reto3doctor.service.ReservationService;
import com.example.reto3doctor.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins="*")
public class ReservationController {
    @Autowired

    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable("id") Integer id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.saveReservation(reservationModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.updateReservation(reservationModel);
    }

    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable Integer idReservation){
        return  reservationService.deleteReservation(idReservation);
    }

}
