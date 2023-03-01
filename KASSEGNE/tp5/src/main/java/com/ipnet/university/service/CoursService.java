package com.ipnet.university.service;

import com.ipnet.university.dao.CoursDao;
import com.ipnet.university.dto.Cours;

import java.util.List;

public class CoursService {

    public Cours saveCours(Cours cours){
        CoursDao coursDao = new CoursDao();
        return coursDao.save(cours);
    }
    
    public List<Cours> getAllCours(){
        CoursDao coursDao = new CoursDao();
        return coursDao.getAll();
    }

    public Cours getCoursById(int id){
        CoursDao coursDao = new CoursDao();
        return coursDao.getById(id);
    }

    public Cours updateCours(Cours cours){
        CoursDao coursDao = new CoursDao();
        return coursDao.update(cours);
    }

    public Cours deleteCours(int id){
        CoursDao coursDao = new CoursDao();
        return coursDao.delete(id);
    }
}
