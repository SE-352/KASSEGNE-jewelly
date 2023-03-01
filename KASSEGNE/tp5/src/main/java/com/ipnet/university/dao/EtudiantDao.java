package com.ipnet.university.dao;

import com.ipnet.university.dto.Etudiant;

import javax.persistence.*;
import java.util.List;

public class EtudiantDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("universitePU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    public Etudiant save(Etudiant etudiant) {
        entityTransaction.begin();
        entityManager.persist(etudiant);
        entityTransaction.commit();
        return etudiant;
    }
    
    
    public Etudiant getById(int id) {
        Etudiant etudiant = entityManager.find(Etudiant.class , id);
        return etudiant;
    }

    
    
    public List<Etudiant> getAll(){
        String sql = "SELECT etudiant FROM Etudiant etudiant";
        Query query = entityManager.createQuery(sql);
        List<Etudiant> etudiantList = query.getResultList();
        return etudiantList;
    }

    public Etudiant update(Etudiant etudiant) {
        Etudiant e = entityManager.find(Etudiant.class , etudiant.getId());
        e.setNom(etudiant.getNom());
        e.setPrenom(etudiant.getPrenom());
        e.setEmail(etudiant.getEmail());
        e.setAdresse(etudiant.getAdresse());
        e.setTelephone(etudiant.getTelephone());
        //e.setDepartement(etudiant.getDepartement());
        entityTransaction.begin();
        entityManager.merge(etudiant);
        entityTransaction.commit();
        return etudiant;
    }

   
    

    public Etudiant delete(int id) {
        Etudiant etudiant = entityManager.find(Etudiant.class , id);
        entityTransaction.begin();
        entityManager.remove(etudiant);
        entityTransaction.commit();
        return etudiant;
    }
}
