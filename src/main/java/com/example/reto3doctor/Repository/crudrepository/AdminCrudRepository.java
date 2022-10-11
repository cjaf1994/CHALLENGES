package com.example.reto3doctor.Repository.crudrepository;


import com.example.reto3doctor.model.AdminModel;
import com.example.reto3doctor.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<AdminModel, Integer>{

}
