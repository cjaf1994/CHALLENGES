package com.example.reto3doctor.service;

import com.example.reto3doctor.Repository.ClientRepository;
import com.example.reto3doctor.Repository.DoctorRepository;
import com.example.reto3doctor.model.ClientModel;
import com.example.reto3doctor.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired

    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors(){
        return doctorRepository.getAllDoctors();
    }
    public Optional<DoctorModel> getDoctor(Integer id){
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel){
        return doctorRepository.saveDoctor(doctorModel);
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorRepository.updateDoctor(doctorModel);
    }

    public boolean deleteDoctor(Integer id) {
        doctorRepository.deleteDoctor(id);
        return true;}


}
