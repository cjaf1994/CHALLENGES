package com.example.reto3doctor.Repository;

import com.example.reto3doctor.Repository.crudrepository.ReservationCrudRepository;
import com.example.reto3doctor.model.ClientModel;
import com.example.reto3doctor.model.Reports.ReportClient;
import com.example.reto3doctor.model.Reports.ReportStatus;
import com.example.reto3doctor.model.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;


    public List<ReservationModel> getAllReservations(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }
    public Optional<ReservationModel> getReservation(Integer id){
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public ReservationModel updateReservation (ReservationModel reservationModel){
        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(Integer id) {
        reservationCrudRepository.deleteById(id);
        return true;
    }

    public List<ReservationModel> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    public List<ReservationModel> getReservationPeriod(Date startDate, Date finishDate){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate, finishDate);
    }

    public List<ReportClient> getTopClient(){
        List<ReportClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countReservationModelByClient();
        for (Object[] i : report) {
            res.add(new ReportClient((Long) i[1], (ClientModel) i[0]));
        }
        return  res;
    }
    public ReportStatus getReportStatus(){
        List<ReservationModel> completed = reservationCrudRepository.findAllByStatus("completed");
        List<ReservationModel> cancelled= reservationCrudRepository.findAllByStatus("cancelled");
        return new ReportStatus(completed.size(),cancelled.size());

    }


}
