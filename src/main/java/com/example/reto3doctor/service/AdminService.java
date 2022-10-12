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
        if(adminModel.getId()==null){
            return adminRepository.saveAdmin(adminModel);
        }else{
            Optional<AdminModel> optionalAdminModel= adminRepository.getAdmin(adminModel.getId());
            if(optionalAdminModel.isEmpty()){
                return adminRepository.saveAdmin(adminModel);
            }else {
                return adminModel;
            }
        }
    }

    public AdminModel updateAdmin(AdminModel adminModel) {
        if (adminModel.getId() != null) {
            Optional<AdminModel> optionalAdminModel =
                    adminRepository.getAdmin((adminModel.getId()));
            if (!optionalAdminModel.isEmpty()) {
                if (adminModel.getName() != null) {
                    optionalAdminModel.get().setName(adminModel.getName());
                }
                if (adminModel.getEmail() != null) {
                    optionalAdminModel.get().setEmail(adminModel.getEmail());
                }
                if (adminModel.getPassword() != null) {
                    optionalAdminModel.get().setPassword(adminModel.getPassword());
                }
                adminRepository.saveAdmin(optionalAdminModel.get());
                return optionalAdminModel.get();

            } else {
                return adminModel;
            }

        }return adminModel;
    }


    public boolean deleteAdmin(Integer id) {
            Boolean aBoolean=getAdmin(id).map(adminModel1 -> {
                adminRepository.deleteAdmin(adminModel1.getId());
                return true;
            }).orElse(false);
            return aBoolean;
        }

}
