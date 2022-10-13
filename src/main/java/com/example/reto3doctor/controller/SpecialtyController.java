package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.SpecialtyModel;
import com.example.reto3doctor.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins="*")
public class SpecialtyController {
    @Autowired

    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/{id}")
    public Optional<SpecialtyModel> getSpecialty(@PathVariable("id") Integer id){
        return specialtyService.getSpecialty(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel saveSpecialty(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.saveSpecialty(specialtyModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel updateService(@RequestBody SpecialtyModel specialtyModel){
        return specialtyService.updateSpecialty(specialtyModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSpecialty(@PathVariable Integer id){
        return  specialtyService.deleteSpecialty(id);
    }

}
