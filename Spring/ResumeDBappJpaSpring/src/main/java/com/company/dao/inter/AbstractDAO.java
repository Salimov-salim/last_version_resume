/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Flut
 */
public abstract class AbstractDAO {
    
    public Connection connect() throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/salim_db",
            "postgres", "6142");
        return c;
    }
    
    EntityManagerFactory emfactory=null;
    
    public EntityManager em(){
        if (emfactory!=null) {
            emfactory=Persistence.createEntityManagerFactory("com.company_ResumeDbAppJpa_jar_1.0PU");
        }
        EntityManager em=emfactory.createEntityManager();
        return em;
    }
    
    public void close(EntityManager em){
        em.close();
        emfactory.close();
    }
    
}
