package com.ipnet.university.service;

import com.ipnet.university.dao.DepartementDao;
import com.ipnet.university.dto.Departement;

import java.util.List;

public class DepartementService {

    public Departement saveDepartement(Departement departement){
        DepartementDao departementDao = new DepartementDao();
        return departementDao.save(departement);
    }
    
    public List<Departement> getAllDepartement(){
        DepartementDao departementDao = new DepartementDao();
        return departementDao.getAll();
    }
    
    public Departement getDepartementById(int id){
        DepartementDao departementDao = new DepartementDao();
        return departementDao.getById(id);
    }
    public Departement updateDepartement(Departement departement){
        DepartementDao departementDao = new DepartementDao();
        return departementDao.update(departement);
    }

    public Departement deleteDepartement(int id){
        DepartementDao departementDao = new DepartementDao();
        return departementDao.delete(id);
    }
}
