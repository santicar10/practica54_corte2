package com.example.practica54_corte2;

import com.example.practica54_corte2.model.Client;
import com.example.practica54_corte2.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Client> clients = em.createQuery("select c from Client c", Client.class).getResultList();
        em.close();
    }
}
