package com.example.reto3doctor.service;

import com.example.reto3doctor.Repository.AdminRepository;
import com.example.reto3doctor.Repository.ClientRepository;
import com.example.reto3doctor.model.AdminModel;
import com.example.reto3doctor.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired

    private AdminRepository adminRepository;

    public List<AdminModel> getAllAdmins(){
        return adminRepository.getAllAdmins();
    }
    public Optional<AdminModel> getAdmin(Integer id){
        return adminRepository.getAdmin(id);
    }

    public AdminModel saveAdmin(AdminModel adminModel){
        return adminRepository.saveAdmin(adminModel);
    }

    public AdminModel updateAdmin(AdminModel adminModel){
        return adminRepository.updateAdmin(adminModel);
    }

    public boolean deleteAdmin(Integer id) {
        adminRepository.deleteAdmin(id);
        return true;}
}
