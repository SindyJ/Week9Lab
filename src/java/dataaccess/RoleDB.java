/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Role;
import models.User;
/**
 *
 * @author Craig Kubinec
 */
public class RoleDB {
    
    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Role> roles = em.createNamedQuery("Roll.findAll", Role.class)
                    .getResultList();
            return roles;
        } finally {
            em.close();
        }
    }
    
    public Role get(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.createNamedQuery("Role.findByRoleId", Role.class)
                    .setParameter("roleId", roleId).getResultList().get(0);
            return role;
        } finally {
            em.close();
        }
    }
}
    