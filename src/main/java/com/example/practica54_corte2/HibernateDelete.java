package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateDelete {
    public static void main(String[] args) {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Input the id of the client to delete"));
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Client cliente = em.find(Client.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
