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
        if(doctorModel.getId()==null){
            return doctorRepository.saveDoctor(doctorModel);
        }else{
            Optional<DoctorModel> optionalDoctorModel= doctorRepository.getDoctor(doctorModel.getId());
            if(optionalDoctorModel.isEmpty()){
                return doctorRepository.saveDoctor(doctorModel);
            }else {
                return doctorModel;
            }

        }

    }



    public DoctorModel updateDoctor(DoctorModel doctorModel) {
        if (doctorModel.getId() != null) {
            Optional<DoctorModel> optionalDoctorModel =doctorRepository.getDoctor((doctorModel.getId()));
            if (!optionalDoctorModel.isEmpty()) {
                if (doctorModel.getName() != null){
                    optionalDoctorModel.get().setName(doctorModel.getName());
                }
                if (doctorModel.getDepartment() != null) {
                    optionalDoctorModel.get().setDepartment(doctorModel.getDepartment());
                }
                if (doctorModel.getYear() != null) {
                    optionalDoctorModel.get().setYear(doctorModel.getYear());
                }
                if (doctorModel.getDescription() != null) {
                    optionalDoctorModel.get().setDescription(doctorModel.getDescription());
                }
                doctorRepository.saveDoctor(optionalDoctorModel.get());
                return optionalDoctorModel.get();
            } else {
                return doctorModel;
            }
        }return doctorModel;
    }

    public boolean deleteDoctor(Integer id) {
        Boolean aBoolean=getDoctor(id).map(doctorModel1 -> {
            doctorRepository.deleteDoctor(doctorModel1.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
