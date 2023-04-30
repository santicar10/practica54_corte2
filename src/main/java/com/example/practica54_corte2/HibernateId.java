package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateId {
    public static void main(String[] args) {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Input the id of the client"));
        EntityManager em = JpaUtil.getEntityManager();
        Client cliente = em.find(Client.class, id);
        System.out.println(cliente);
        em.close();
    }
}
