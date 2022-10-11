package com.example.reto3doctor.service;


import com.example.reto3doctor.Repository.ReservationRepository;
import com.example.reto3doctor.Repository.SpecialtyRepository;
import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired

    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationRepository.saveReservation(reservationModel);
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        return reservationRepository.updateReservation(reservationModel);
    }

    public boolean deleteReservation(Integer id) {
        reservationRepository.deleteReservation(id);
        return true;}


}
