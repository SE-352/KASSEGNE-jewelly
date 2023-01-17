package tg.ipnet.university.tp4;

import java.util.*;

import javax.persistence.*;

import tg.ipnet.university.tp4.entities.Cours;
import tg.ipnet.university.tp4.entities.Departement;
import tg.ipnet.university.tp4.entities.Etudiant;
import tg.ipnet.university.tp4.entities.Professeur;
 
public class Main {
	
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("universitePU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction et = em.getTransaction();
        et.begin();
      
        Departement departement1 = new Departement("Biologie vétégale", "biologie.com");
        Departement departement2 = new Departement("Informatique", "informatique.com");
        
        Set<Departement> departements1 = new HashSet<>();
        Set<Departement> departements2 = new HashSet<>();
        Set<Departement> departements3 = new HashSet<>();
        departements1.add(departement1);
        departements2.add(departement2);
        departements3.add(departement1);
        departements3.add(departement2);
        
        
        Etudiant etudiant1 = new Etudiant("WONA", "flore", "flore@ipnetinstitute.com", "Lomé - TOGO", "90887890");
        etudiant1.setDepartement(departement2);
        Etudiant etudiant2 = new Etudiant("MIAKO", "celine", "celine@ipnetinstitute.com", "Lomé - TOGO", "99788938");
        etudiant2.setDepartement(departement1);
        Etudiant etudiant3 = new Etudiant("KASS", "jes", "jes@ipnetinstitute.com", "Lomé - TOGO", "99262704");
        etudiant3.setDepartement(departement1);
        Etudiant etudiant4 = new Etudiant("KASS", "Emile", "kass@ipnetinstitute.com", "Lomé - TOGO", "70456789");
        etudiant4.setDepartement(departement2);
        
        em.persist(etudiant1);
        em.persist(etudiant2);
        em.persist(etudiant3);
        em.persist(etudiant4);
   
        Professeur professeur1 = new Professeur("AYENA", "Adebayor", "adebayor.ayena@ipnetinstitute.com", "Classe exceptionnelle", null, null);
        Professeur professeur2 = new Professeur("BATANA", "Ferdinand", "ferdinand.batana@ipnetinstitute.com", "Classe normale", null, null);
        Professeur professeur3 = new Professeur("SOGNON", "Rosine", "tassivi.sognon@ipnetinstitute.com", "Classe normale ", null, null);
        
        Set<Professeur> professeurs1 = new HashSet<>();
        Set<Professeur> professeurs2 = new HashSet<>();
        Set<Professeur> professeurs3 = new HashSet<>();
        
        professeurs1.add(professeur1);
        professeurs2.add(professeur2);
        professeurs3.add(professeur3);
        
        Cours cour1 = new Cours("Bioligie Moléculaire", new Date(), professeurs1);
        Cours cour2 = new Cours("Programmation Orientée Objet", new Date(), professeurs2);
        Cours cour3 = new Cours("Analyse Numérique", new Date(), professeurs3);
        Set<Cours> cours1 = new HashSet<>();
        Set<Cours> cours2 = new HashSet<>();
        Set<Cours> cours3 = new HashSet<>();
        cours1.add(cour1);
        cours2.add(cour2);
        cours3.add(cour3);
        
        em.persist(cour1);
        em.persist(cour2);
        em.persist(cour3);
        
        professeur1.setCours(cours1);
        professeur2.setCours(cours2);
        professeur3.setCours(cours3);
        
        professeur1.setDepartements(departements1);
        professeur2.setDepartements(departements2);
        professeur3.setDepartements(departements3);
        
        em.persist(professeur1);
        em.persist(professeur2);
        em.persist(professeur3);
        
        Query nomsEtudiants = em.createQuery("SELECT e FROM Etudiant e");
        List<Etudiant> resultats = nomsEtudiants.getResultList();  
        System.out.println("Nom Etudiant :");  
        for(Etudiant r:resultats) {  
              
           System.out.println(r.getNom());  
        
             
        }
        
        Query etudiants = em.createQuery("SELECT e FROM Etudiant e ORDER BY e.nom, e.prenom, e.telephone");
        List<Etudiant> reponses= (List<Etudiant>)etudiants.getResultList( );  
        
        for(Etudiant r:reponses) {          
           System.out.println("Nom : "+r.getNom());  
           System.out.println("Prenom : "+r.getPrenom());
           System.out.println("Numero téléphone : "+r.getTelephone());
        }
      
        Query nomsProfesseurs = em.createNamedQuery("selectNomsProfesseurs"); 
        List<Professeur> professeurs = nomsProfesseurs.getResultList();  
        System.out.println("Nom Professeur :");  
        for(Professeur r:professeurs) {  
              
           System.out.println(r.getNom());     
             
        }
      
        Cours cour4 = new Cours("Parasitologie des plantes", new Date(), professeurs1);
        Cours cour5 = new Cours("Parasites", new Date(), professeurs1);
        Cours cour6 = new Cours("Statistiques", new Date(), professeurs3);
        
        Set<Cours> cours4 = new HashSet<>();
        Set<Cours> cours5 = new HashSet<>();
        Set<Cours> cours6 = new HashSet<>();
        cours4.add(cour4);
        cours5.add(cour5);
        cours6.add(cour6);
        
        cour4.setDepartements(departements3);
        cour5.setDepartements(departements3);
        cour6.setDepartements(departements3);
        
        professeur1.setCours(cours4);
        professeur1.setCours(cours5);
        professeur3.setCours(cours6);
        
        em.persist(professeur1);
        em.persist(professeur3);
        
        em.persist(cour4);
        em.persist(cour5);
        em.persist(cour6);
        
        
        et.commit();
        em.close();
        emf.close();
        
    }
}
