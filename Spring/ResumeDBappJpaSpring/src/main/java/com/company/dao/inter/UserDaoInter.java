/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Users;
import java.util.List;

/**
 *
 * @author Flut
 */
public interface UserDaoInter {
    
    public List<Users> getAll();
//    
    public boolean updateUser(Users u);
//    
    public boolean deleteUser(int id);
//    
    public Users getUserById(int id);
    
    public void insertUser(Users u);
    
    public Users findByEmail(String email);
}
