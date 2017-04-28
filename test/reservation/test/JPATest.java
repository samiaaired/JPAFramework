/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import reservation.entity.Chambre;
import reservation.entity.Hotel;
import reservation.entity.Adresse;

/**
 *
 * @author formation
 */
public class JPATest {
    
    
    @Test
    public void demarrerJPA(){
        
        Persistence.createEntityManagerFactory("PU").createEntityManager();
    }
    
   // @Test
    public void recupChambreId1(){
         EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
         EntityManager em3 =   factory.createEntityManager();
         Chambre chambre = em3.find(Chambre.class, 1L);
         System.out.println(String.format("chambre: id=%d nom=%s prix=%9.2f hotel=%s", chambre.getId(),
                 chambre.getNom(), chambre.getPrix(), chambre.getHotel().getNom()));
    }

    //@Test
    public void ajouterHotel() {
        EntityManager em2= Persistence.createEntityManagerFactory("PU").createEntityManager();
        Hotel hotel1= new Hotel();
        Adresse adresseHotel =new Adresse();
        adresseHotel.setCodePostale(75008L);
        adresseHotel.setLocalite("Paris");
        adresseHotel.setPays("France");
        adresseHotel.setRue("45 avanue des champs Elysées");
        
        hotel1.setNom("sheraton");
        hotel1.setAdresse(adresseHotel);
       
        em2.getTransaction().begin();
        em2.persist(hotel1); 
        em2.getTransaction().commit();
       

    }

   // @Test
    public void ajouterChambre() {

        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Chambre c = new Chambre();
        c.setNom("Suite Royale4");
        c.setPrix(20000.0);
        c.setDescription("ce n'est pas cher");
        

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

    }

}
