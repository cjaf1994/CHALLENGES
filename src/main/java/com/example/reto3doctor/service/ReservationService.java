package com.example.reto3doctor.service;


import com.example.reto3doctor.Repository.ReservationRepository;
import com.example.reto3doctor.Repository.SpecialtyRepository;
import com.example.reto3doctor.model.Reports.ReportClient;
import com.example.reto3doctor.model.Reports.ReportStatus;
import com.example.reto3doctor.model.ReservationModel;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        if(reservationModel.getIdReservation()==null){
            return reservationRepository.saveReservation(reservationModel);
        }else{
            Optional<ReservationModel> optionalReservationModel= reservationRepository.getReservation(reservationModel.getIdReservation());
            if(optionalReservationModel.isEmpty()){
                return reservationRepository.saveReservation(reservationModel);
            }else {
                return reservationModel;
            }

        }

    }

    public ReservationModel updateReservation(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> optionalReservationModel =reservationRepository.getReservation((reservationModel.getIdReservation()));
            if (!optionalReservationModel.isEmpty()) {
                if (reservationModel.getStartDate() != null){
                    optionalReservationModel.get().setStartDate(reservationModel.getStartDate());
                    optionalReservationModel.get().setDoctor(reservationModel.getDoctor());
                    optionalReservationModel.get().setClient(reservationModel.getClient());
                    optionalReservationModel.get().setScore(reservationModel.getScore());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    optionalReservationModel.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }

                //boolean
                if (reservationModel.getStatus () != null) {
                    optionalReservationModel.get().setStatus(reservationModel.getStatus());
                }
                reservationRepository.saveReservation(optionalReservationModel.get());
                return optionalReservationModel.get();
            } else {
                return reservationModel;
            }
        }return reservationModel;
    }

    public boolean deleteReservation(Integer id) {
        Boolean aBoolean=getReservation(id).map(reservationModel1 -> {
            reservationRepository.deleteReservation(reservationModel1.getIdReservation());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<ReservationModel> getReservationByStatus(String status){
        return reservationRepository.getReservationByStatus(status);
    }
    public List<ReportClient> getTopClient(){
        return reservationRepository.getTopClient();
    }
    public ReportStatus getReportStatus(){
        return reservationRepository.getReportStatus();
    }
    public List<ReservationModel> getReservationPeriod(String date1, String date2){
        SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate =  new Date();
        Date finishDate = new Date();
        try{
            startDate = parseDate.parse(date1);
            finishDate= parseDate.parse(date2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (startDate.before(finishDate)) {
            return reservationRepository.getReservationPeriod(startDate,finishDate);
        }else{
            return new ArrayList<>();
        }
    }


}
