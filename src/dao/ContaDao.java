/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Models.Conta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author marco
 */
public class ContaDao {

    public void save() {
        EntityManager manager = null;
        try {
            manager = Persistence.createEntityManagerFactory("app_JPAPU").createEntityManager();
            manager.getTransaction().begin();

            Conta conta = new Conta();
            conta.setCnt_descricao("Conta de Teste ");
            conta.setCnt_saldo(100.00);

            manager.persist(conta);
            manager.getTransaction().commit();
            System.out.println("Inserção feita com sucesso!");
        } catch (Exception err) {
            err.printStackTrace();
            if (manager != null) {
                System.out.println("Rollback");
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void load() {
        EntityManager manager = null;
        try {
            manager = Persistence.createEntityManagerFactory("app_JPAPU").createEntityManager();
            manager.getTransaction().begin();

            Conta conta = manager.find(Conta.class, 2);
            System.out.println("Conta: " + conta.getCnt_descricao() + ", "
                    + "Saldo: " + conta.getCnt_saldo());

            manager.getTransaction().commit();
        } catch (Exception err) {
            err.printStackTrace();
            if (manager != null) {
                System.out.println("Rollback");
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void update() {
        EntityManager manager = null;
        try {
            manager = Persistence.createEntityManagerFactory("app_JPAPU").createEntityManager();
            manager.getTransaction().begin();
            
            Conta conta = manager.find(Conta.class, 2);

            manager.clear();
            conta.setCnt_descricao("Descrição atualizada!");

            manager.merge(conta);
            manager.getTransaction().commit();
            System.out.println("Conta foi atualizada");
        } catch (Exception err) {
            err.printStackTrace();
            if (manager != null) {
                System.out.println("Rollback");
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void delete() {
        EntityManager manager = null;
        try {
            manager = Persistence.createEntityManagerFactory("app_JPAPU").createEntityManager();
            manager.getTransaction().begin();
            
            Conta conta = manager.find(Conta.class, 2);

            manager.remove(conta);
            manager.getTransaction().commit();
            
            System.out.println("Conta foi removida");
        } catch (Exception err) {
            err.printStackTrace();
            if (manager != null) {
                System.out.println("Rollback");
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

}
