/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.entity.Users;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Flut
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

//    public Users getUser(ResultSet rs)throws Exception{
//        int id = rs.getInt("id");
//        String name = rs.getString("name");
//        String surname = rs.getString("surname");
//        String phone = rs.getString("phone");
//        String email = rs.getString("email");
//        String address=rs.getString("adress");
//        String profileDescription=rs.getString("profiledescription");
//        Date birthDate=rs.getDate("birthdate");
//        int nationalityID=rs.getInt("nationality_id");
//        int countryID=rs.getInt("birthplace_id");
//        String nationalityName=rs.getString("nationality");
//        String countryName=rs.getString("birthplace");
//        Country natinolity=new Country(nationalityID,null,nationalityName);
//        Country country=new Country(countryID,countryName,null);
//        Users u = new Users(id, name, surname, phone, email,address,profileDescription,birthDate,country,natinolity);
//        return u;
//    }
//    
//    
    @Override
    public List<Users> getAll() {
        List<Users> userList = new ArrayList<>();
        String jpql="select * from users";
        
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select u.*,c.nationality as nationality,c2.\"name\" as birthplace\n" +
                         "from javac.users u\n" +
                         "left join javac.country c on u.nationality_id =c.id\n" +
                         "left join javac.country c2 on u.birthplace_id =c2.id ");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
//                Users u=getUser(rs);
//                userList.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }
//
    @Override
    public boolean updateUser(Users u) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        close(em);
        return true;
    }
//
    @Override
    public boolean deleteUser(int id) {
        EntityManager em=em();
        em.getTransaction().begin();
        Users u=em.find(Users.class, id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
        close(em);
        return true;
    }

    @Override
    public Users getUserById(int id) {
        EntityManager em=em();
        em.getTransaction().begin();
        Users u=em.find(Users.class, id);
         em.getTransaction().commit();
        close(em);
        return u;
    }

//   
//
    @Override
    public void insertUser(Users u) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        close(em);
    }

        //    JPQL
    @Override
    public Users findByEmail(String email) {
        EntityManager em=em();
        Query q=em.createQuery("select s from users s where s.email=:e",Users.class);
        q.setParameter("e", email);
        List<Users> list=q.getResultList();
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

}
