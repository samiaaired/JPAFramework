/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import reservation.entity.Chambre;

/**
 *
 * @author formation
 */
public class JPATest {
   @Test 
   public void testJPA(){
       
       EntityManager em= Persistence.createEntityManagerFactory("PU").createEntityManager();
       Chambre c = new Chambre();
       c.setNom("Suite Royale");
       c.setPrix(20000.0);
       c.setDescription("ce n'est pas cher");
       
       em.getTransaction().begin();
       em.persist(c);
       em.getTransaction().commit();
       
   }
    
}
