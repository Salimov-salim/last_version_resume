/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;
import com.company.entity.Users;
import com.company.entity.UserSkill;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter{

    public UserSkill getAllSkill(ResultSet rs) throws Exception{
        int user_id=rs.getInt("id");
        int power=rs.getInt("power");
        String skill_name=rs.getString("skill_name");
        int skill_id=rs.getInt("skill_id");
//        return new UserSkill(user_id,new Users(user_id),new Skill(skill_id,skill_name),power);
        return null;
    }
    
    
    @Override
    public List<UserSkill> getAllUserSkills(int userId) {
        List<UserSkill> userSkill=new ArrayList<>();
        try(Connection conn=connect()){
            PreparedStatement ps=conn.prepareStatement("select u.*,us.skill_id ,us.power,s.\"name\" as skill_name from javac.user_skill us \n" +
                                    "left join javac.users u on us.user_id =u.id \n" +
                                    "left join javac.skill s on us.skill_id =s.id \n" +
                                    "where us.user_id =?");
            ps.setInt(1, userId);
            ps.execute();
            ResultSet rs=ps.getResultSet();
            while(rs.next()){
                UserSkill u=getAllSkill(rs);
                userSkill.add(u);
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return userSkill;
    }
    
}
