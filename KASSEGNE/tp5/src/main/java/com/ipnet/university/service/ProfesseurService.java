package com.ipnet.university.service;

import com.ipnet.university.dao.ProfesseurDao;
import com.ipnet.university.dto.Professeur;

import java.util.List;

public class ProfesseurService {

    public Professeur saveProfesseur(Professeur professeur){
        ProfesseurDao professeurDao = new ProfesseurDao();
        return professeurDao.save(professeur);
    }
    
    public List<Professeur> getAllProfesseur(){
        ProfesseurDao professeurDao = new ProfesseurDao();
        return professeurDao.getAll();
    }
    
    public Professeur getProfesseurById(int id){
        ProfesseurDao professeurDao = new ProfesseurDao();
        return professeurDao.getById(id);
    }


    public Professeur updateProfesseur(Professeur professeur){
        ProfesseurDao professeurDao = new ProfesseurDao();
        return professeurDao.update(professeur);
    }
    
    public Professeur deleteProfesseur(int id){
        ProfesseurDao professeurDao = new ProfesseurDao();
        return professeurDao.delete(id);
    }
}
