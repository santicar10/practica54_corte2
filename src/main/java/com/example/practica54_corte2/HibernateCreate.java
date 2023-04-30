package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCreate {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String name = JOptionPane.showInputDialog("Input the name of the client: ");
            String lastname = JOptionPane.showInputDialog("Input the lastname of the client:");
            String payment = JOptionPane.showInputDialog("Input the payment method of the client:");
            em.getTransaction().begin();
            Client client = new Client();
            client.setName(name);
            client.setLastName(lastname);
            client.setMethodPayment(payment);
            em.persist(client);
            em.getTransaction().commit();
            System.out.println("the id of the register client is " + client.getId());
            client = em.find(Client.class, client.getId());
            System.out.println(client);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
