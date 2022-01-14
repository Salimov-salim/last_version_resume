/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.EmploymentHistory;
import com.company.entity.Users;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter{

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory(int id_) {
        List<EmploymentHistory> employment_list=new ArrayList<>();
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("select * from javac.employment_history eh where eh.user_id=?");
            ps.setInt(1, id_);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while(rs.next()){
                int id=rs.getInt("id");
                String title=rs.getString("title");
                Date start_date=rs.getDate("startDate");
                Date end_date=rs.getDate("enddate");
                int user_id=rs.getInt("user_id");
//                employment_list.add(new EmploymentHistory(id,title,start_date,end_date,new Users(user_id)));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return employment_list;
    }
    
}
