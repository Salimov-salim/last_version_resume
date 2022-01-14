/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Country;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{

    public Country getAllCountry(ResultSet rs)throws Exception{
        int id=rs.getInt("id");
        String country_name=rs.getString("name");
        String nationality=rs.getString("nationality");
//        return new Country(id,country_name,nationality);
        return null;
    }
    
    @Override
    public List<Country> getCountry(int id) {
        List<Country> country_list=new ArrayList<>();
        try(Connection conn=connect()){
            PreparedStatement ps=conn.prepareStatement("select * from javac.country c where c.id =?");
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while(rs.next()){
                Country c=getAllCountry(rs);
                country_list.add(c);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return country_list;
    }
    
}
