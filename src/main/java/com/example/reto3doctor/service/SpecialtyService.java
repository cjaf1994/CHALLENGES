package com.example.reto3doctor.service;


import com.example.reto3doctor.Repository.SpecialtyRepository;
import com.example.reto3doctor.model.SpecialtyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired

    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyRepository.getAllSpecialties();
    }

    public Optional<SpecialtyModel> getSpecialty(Integer id){
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel){
        return specialtyRepository.saveSpecialty(specialtyModel);
    }

    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel){
        return specialtyRepository.updateSpecialty(specialtyModel);
    }
    public boolean deleteSpecialty(Integer id) {
        specialtyRepository.deleteSpecialty(id);
        return true;}

}
