package com.example.reto3doctor.controller;

import com.example.reto3doctor.model.AdminModel;
import com.example.reto3doctor.model.ClientModel;
import com.example.reto3doctor.service.AdminService;
import com.example.reto3doctor.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins="*")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/all")
    public List<AdminModel> getAllAdmins(){
        return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public Optional<AdminModel> getAdmin(@PathVariable("id") Integer id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveAdmin(@RequestBody AdminModel adminModel){
        return adminService.saveAdmin(adminModel);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel updateAdmin(@RequestBody AdminModel adminModel){
        return adminService.updateAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable Integer id){
        return  adminService.deleteAdmin(id);
    }



}
