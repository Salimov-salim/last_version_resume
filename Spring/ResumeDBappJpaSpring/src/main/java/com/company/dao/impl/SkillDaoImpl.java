/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter{

    @Override
    public List<Skill> getList(int id_) {
        List<Skill> skill_list=new ArrayList<>();
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("select * from javac.skill s  where c.id =?");
            ps.setInt(1, id_);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while(rs.next()){
                int id=rs.getInt("id");
                String skill_name=rs.getString("name");
//                skill_list.add(new Skill(id,skill_name));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return skill_list;
    }
    
}
