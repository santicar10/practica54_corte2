package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateUpdate {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Long id=Long.parseLong(JOptionPane.showInputDialog("Input the id to update: "));
            Client cliente = em.find(Client.class, id);
            String name = JOptionPane.showInputDialog("Input the name of the client: ");
            String lastname = JOptionPane.showInputDialog("Input the lastname of the client:");
            String payment = JOptionPane.showInputDialog("Input the payment method of the client:");
            em.getTransaction().begin();
            cliente.setName(name);
            cliente.setLastName(lastname);
            cliente.setMethodPayment(payment);
            em.getTransaction().commit();
            System.out.println("the client updated id " + cliente);
            cliente = em.find(Client.class, cliente.getId());
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
