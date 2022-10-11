package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.ClientModel;
import com.example.reto3doctor.model.DoctorModel;
import com.example.reto3doctor.service.ClientService;
import com.example.reto3doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins="*")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;


    @GetMapping("/all")
    public List<DoctorModel> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Optional<DoctorModel> getDoctor(@PathVariable("id") Integer id){
        return doctorService.getDoctor(id);
    }
    @PostMapping("/save")
    public DoctorModel saveDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.saveDoctor(doctorModel);
    }

    @PutMapping("/update")
    public DoctorModel updateDoctor(@RequestBody DoctorModel doctorModel){
        return doctorService.updateDoctor(doctorModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteDoctor(@PathVariable Integer id){
        return  doctorService.deleteDoctor(id);
    }

}
