package com.example.reto3doctor.Repository;

import com.example.reto3doctor.Repository.crudrepository.AdminCrudRepository;
import com.example.reto3doctor.Repository.crudrepository.ClientCrudRepository;
import com.example.reto3doctor.model.AdminModel;
import com.example.reto3doctor.model.ClientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<AdminModel> getAllAdmins(){
        return (List<AdminModel>) adminCrudRepository.findAll();
    }
    public Optional<AdminModel> getAdmin(Integer id){
        return adminCrudRepository.findById(id);
    }
    public AdminModel saveAdmin(AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }

    public AdminModel updateAdmin(AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }

    public boolean deleteAdmin(Integer id) {
        adminCrudRepository.deleteById(id);
        return true;
    }

}
