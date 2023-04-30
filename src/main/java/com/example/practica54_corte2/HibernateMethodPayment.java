package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.List;

public class HibernateMethodPayment {
    public static void main(String[] args) {
        String payment= JOptionPane.showInputDialog("Input your payment method");
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Client c where c.methodPayment=?1" + "", Client.class);
        query.setParameter(1, payment);
        List<Client> clientes = query.getResultList();
        System.out.println(clientes);
        em.close();
    }
}
