/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_jpa;

import Models.Conta;
import dao.ContaDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marco
 */
public class App_JPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContaDao dao = new ContaDao();
        
        dao.save();
//        dao.load();
//        dao.update();
//        dao.delete();
    }
}
