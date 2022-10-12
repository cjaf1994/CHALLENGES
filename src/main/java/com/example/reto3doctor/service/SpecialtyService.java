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
        if(specialtyModel.getId()==null){
            return specialtyRepository.saveSpecialty(specialtyModel);
        }else{
            Optional<SpecialtyModel> optionalSpecialtyModel= specialtyRepository.getSpecialty(specialtyModel.getId());
            if(optionalSpecialtyModel.isEmpty()){
                return specialtyRepository.saveSpecialty(specialtyModel);
            }else {
                return specialtyModel;
            }

        }

    }
    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel) {
        if (specialtyModel.getId() != null) {
            Optional<SpecialtyModel> optionalSpecialtyModel = specialtyRepository.getSpecialty((specialtyModel.getId()));
            if (!optionalSpecialtyModel.isEmpty()) {
                if (specialtyModel.getName() != null) {
                    optionalSpecialtyModel.get().setName(specialtyModel.getName());
                }
                if (specialtyModel.getDescription() != null) {
                    optionalSpecialtyModel.get().setDescription(specialtyModel.getDescription());
                }
                specialtyRepository.saveSpecialty(optionalSpecialtyModel.get());
                return optionalSpecialtyModel.get();
            } else {
                return specialtyModel;
            }

        }else {
            return specialtyModel;
        }

    }




    public boolean deleteSpecialty(Integer id) {
        Boolean aBoolean=getSpecialty(id).map(specialtyModel1 -> {
            specialtyRepository.deleteSpecialty(specialtyModel1.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
