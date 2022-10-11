package com.example.reto3doctor.Repository;

import com.example.reto3doctor.Repository.crudrepository.DoctorCrudRepository;
import com.example.reto3doctor.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorRepository {

    @Autowired
    private DoctorCrudRepository doctorCrudRepository;

    public List<DoctorModel> getAllDoctors(){
        return (List<DoctorModel>) doctorCrudRepository.findAll();
    }
    public Optional<DoctorModel> getDoctor(Integer id){
        return doctorCrudRepository.findById(id);
    }
    public DoctorModel saveDoctor(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }

    public DoctorModel updateDoctor(DoctorModel doctorModel){
        return doctorCrudRepository.save(doctorModel);
    }

    public boolean deleteDoctor(Integer id) {
        doctorCrudRepository.deleteById(id);
        return true;
    }

}
